package pro.sky.test.newmockitotest.service;

import org.springframework.stereotype.Service;
import pro.sky.test.newmockitotest.model.User;

@Service
public interface UserService {
    boolean checkUserExist(User user);
}
