package pro.sky.test.newmockitotest.repository;

import org.springframework.stereotype.Repository;
import pro.sky.test.newmockitotest.model.User;

import java.util.List;

@Repository
public interface UserDao {

    User getUserByName(String searchName);

    List<User> findAllUsers();
}
