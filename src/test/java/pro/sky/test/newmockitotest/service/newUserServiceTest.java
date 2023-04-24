package pro.sky.test.newmockitotest.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import pro.sky.test.newmockitotest.model.User;
import pro.sky.test.newmockitotest.repository.UserDao;
import pro.sky.test.newmockitotest.service.impls.UserServiceImpl;


import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {UserServiceImpl.class})

public class newUserServiceTest {
    @MockBean
    private UserDao daoMock1;

    @Autowired
    private UserService out;

    private User user1;
    private User user2;
    private User notExistedUser;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
        user1 = new User("MrFirst", 33);
        user2 = new User("MrSecond", 40);

        notExistedUser = new User("MrNotExisted", 60);

    }

    @Test
    public void checkUserExistTest() {
        when(daoMock1.getUserByName("MrFirst")).thenReturn(user1);
        when(daoMock1.getUserByName("MrSecond")).thenReturn(user2);

        assertTrue(out.checkUserExist(user1));
        assertTrue(out.checkUserExist(user2));
        assertFalse(out.checkUserExist(notExistedUser));

        verify(daoMock1, times(1)).getUserByName("MrFirst");
        verify(daoMock1, times(1)).getUserByName("MrSecond");
    }
}
