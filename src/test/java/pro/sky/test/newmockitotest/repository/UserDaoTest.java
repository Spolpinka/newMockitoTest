package pro.sky.test.newmockitotest.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pro.sky.test.newmockitotest.model.User;
import pro.sky.test.newmockitotest.repository.impls.UserDaoImpl;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoTest {

    private UserDao userDao;
    User user1;
    User user2;

    private String nameOne = "MrFirst";
    private String nameTwo = "MrSecond";
    private String notExisted = "MrNotExisted";

    User notExistedUser;

    @BeforeEach
    void setUp() {
        userDao = new UserDaoImpl();

        user1 = new User(nameOne, 33);
        user2 = new User(nameTwo, 40);

        notExistedUser = new User(notExisted, 15);

    }

    @Test
    void getUserByNameTest() {
        assertEquals(userDao.getUserByName(nameOne), user1);
        assertEquals(userDao.getUserByName(nameTwo), user2);

        assertNull(userDao.getUserByName(notExisted));
    }
}