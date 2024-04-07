package ar.edu.itba.paw.persistence;

import ar.edu.itba.paw.interfaces.dao.UserDao;
import ar.edu.itba.paw.models.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {
    @Override
    public User findById(int id) {
        final User user = new User();

        user.setId(1);
        user.setEmail("fquesada@itba.edu.ar");
        user.setFirstName("Francisco");
        user.setLastName("Quesada");
        user.setAge(23);

        return user;
    }
}
