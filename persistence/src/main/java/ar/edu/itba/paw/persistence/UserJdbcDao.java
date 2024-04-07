package ar.edu.itba.paw.persistence;

import ar.edu.itba.paw.interfaces.dao.UserDao;
import ar.edu.itba.paw.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserJdbcDao implements UserDao {

  private final JdbcTemplate jdbcTemplate;
  private final SimpleJdbcInsert jdbcInsert;

  private static final RowMapper<User> ROW_MAPPER =
      (rs, rowNum) ->
          new User(
              rs.getLong("id"),
              rs.getString("email"),
              rs.getString("firstName"),
              rs.getString("lastName"),
              rs.getInt("age"));

  @Autowired
  public UserJdbcDao(final DataSource ds) {
    jdbcTemplate = new JdbcTemplate(ds);
    jdbcInsert =
        new SimpleJdbcInsert(jdbcTemplate).withTableName("users").usingGeneratedKeyColumns("id");
    jdbcTemplate.execute(
        "CREATE	TABLE IF NOT EXISTS	users ("
            + "id SERIAL PRIMARY KEY,"
            + "email varchar(100),"
            + "firstName varchar(100),"
            + "lastName varchar(100),"
            + "age int"
            + ")");
  }

  @Override
  public User findById(int id) {
    final List<User> list =
        jdbcTemplate.query("SELECT * FROM users	WHERE id = ?", ROW_MAPPER, id);
    if (list.isEmpty()) {
      return null;
    }
    return list.get(0);
  }

  @Override
  public User create(String email, String firstName, String lastName, int age) {
    final Map<String, Object> args = new HashMap<>();
    args.put("email", email);
    args.put("firstName", firstName);
    args.put("lastName", lastName);
    args.put("age", age);
    final Number userId = jdbcInsert.executeAndReturnKey(args);
    return new User(userId.longValue(), email, firstName, lastName, age);
  }
}
