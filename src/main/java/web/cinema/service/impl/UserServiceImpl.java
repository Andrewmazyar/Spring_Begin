package web.cinema.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import web.cinema.dao.UserDao;
import web.cinema.models.User;
import web.cinema.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void add(User user) {
        userDao.add(user);
    }

    @Override
    public List<User> listUsers() {
        return userDao.getAll();
    }

    @Override
    public User get(Long id) {
        return userDao.get(id);
    }
}
