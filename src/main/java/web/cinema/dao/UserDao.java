package web.cinema.dao;

import java.util.List;
import web.cinema.models.User;

public interface UserDao {
    User add(User user);

    List<User> getAll();
}
