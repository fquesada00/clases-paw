package ar.edu.itba.paw.service;

import ar.edu.itba.paw.interfaces.dao.UserDao;
import ar.edu.itba.paw.models.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {

  private static final String EMAIL = "user@mail.com";
  private static final String FIRST_NAME = "John";
  private static final String LAST_NAME = "Doe";
  private static final int AGE = 50;
  private static final String PASSWORD = "password";

  @Mock private UserDao mockDao;
  @InjectMocks private UserServiceImpl userService;

  @Test
  public void testCreate() {
    Mockito.when(
            mockDao.create(
                Mockito.eq(EMAIL),
                Mockito.eq(FIRST_NAME),
                Mockito.eq(LAST_NAME),
                Mockito.eq(AGE),
                Mockito.eq(PASSWORD)))
        .thenReturn(new User(1, EMAIL, FIRST_NAME, LAST_NAME, AGE, PASSWORD));

    User user = userService.create(EMAIL, FIRST_NAME, LAST_NAME, AGE, PASSWORD);

    Assert.assertNotNull(user);
    Assert.assertEquals(EMAIL, user.getEmail());
    Assert.assertEquals(FIRST_NAME, user.getFirstName());
    Assert.assertEquals(LAST_NAME, user.getLastName());
    Assert.assertEquals(EMAIL, user.getEmail());
    Assert.assertEquals(PASSWORD, user.getPassword());
  }
}
