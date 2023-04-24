package pro.sky.test.newmockitotest.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import pro.sky.test.newmockitotest.model.User;
import pro.sky.test.newmockitotest.repository.UserDao;
import pro.sky.test.newmockitotest.repository.impls.UserDaoImpl;
import pro.sky.test.newmockitotest.service.impls.UserServiceImpl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserServiceTest {

    @Mock
    UserDao userDao = new UserDaoImpl();//если будет просто UserDao, то выведет, что объект равен null

    @InjectMocks
    UserService out = new UserServiceImpl(userDao); //тоже самое, выводит, что объект null

    User user1;
    User user2;

    User notExistedUser;

    private String nameOne = "MrFirst";
    private String nameTwo = "MrSecond";
    private String notExisted = "MrNotExisted";

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        user1 = new User(nameOne, 33);
        user2 = new User(nameTwo, 40);

        notExistedUser = new User(notExisted, 55);

    }

    @Test
    void checkUserExistTest() {
        assertTrue(out.checkUserExist(user1));//проходит тест
        assertTrue(out.checkUserExist(user2));//проходит тест
        assertFalse(out.checkUserExist(notExistedUser));//проходит тест

        when(userDao.getUserByName(nameOne)).thenReturn(user1);
        when(userDao.getUserByName(nameTwo)).thenReturn(user2);

        verify(userDao, times(1)).getUserByName(nameOne);
        verify(userDao, times(1)).getUserByName(nameTwo);

    }
}