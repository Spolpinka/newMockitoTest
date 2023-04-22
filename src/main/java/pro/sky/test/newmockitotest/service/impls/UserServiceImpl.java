package pro.sky.test.newmockitotest.service.impls;

import org.springframework.stereotype.Service;
import pro.sky.test.newmockitotest.model.User;
import pro.sky.test.newmockitotest.repository.UserDao;
import pro.sky.test.newmockitotest.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public boolean checkUserExist(User user) {
        if (userDao.getUserByName(user.getName()) == null) {
            return false;
        } else {
            return true;
        }
    }
}
