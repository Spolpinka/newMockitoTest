package pro.sky.test.newmockitotest.repository.impls;

import org.springframework.stereotype.Repository;
import pro.sky.test.newmockitotest.model.User;
import pro.sky.test.newmockitotest.repository.UserDao;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    private final List<User> users = new ArrayList<>();

    public UserDaoImpl() {
        users.add(new User("MrFirst", 33));
        users.add(new User("MrSecond", 40));

    }

    @Override
    public User getUserByName(String searchName) {
        for (User user :
                users) {
            if (user.getName().equals(searchName)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public List<User> findAllUsers() {
        return users;
    }
}
