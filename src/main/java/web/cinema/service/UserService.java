package web.cinema.service;

import java.util.List;
import web.cinema.models.User;

public interface UserService {
    void add(User user);

    List<User> listUsers();
}
