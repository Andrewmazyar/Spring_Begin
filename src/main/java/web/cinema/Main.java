package web.cinema;

import java.util.List;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import web.cinema.config.AppConfig;
import web.cinema.models.User;
import web.cinema.service.UserService;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context
                = new AnnotationConfigApplicationContext(AppConfig.class);
        final UserService userService = context.getBean(UserService.class);

        User user1 = new User();
        user1.setEmail("user1@gmail.com");
        user1.setPassword("password1");
        User user2 = new User();
        user2.setEmail("user2@gmail.com");
        user2.setPassword("password2");
        User user3 = new User();
        user3.setEmail("user3@gmail.com");
        user3.setPassword("password3");
        User user4 = new User();
        user4.setEmail("user4@gmail.com");
        user4.setPassword("password4");
        User user5 = new User();
        user5.setEmail("user5@gmail.com");
        user5.setPassword("password5");
        User user6 = new User();
        user6.setEmail("user6@gmail.com");
        user6.setPassword("password6");
        userService.add(user1);
        userService.add(user2);
        userService.add(user3);
        userService.add(user4);
        userService.add(user5);
        userService.add(user6);

        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("id: " + user.getId());
            System.out.println("email: " + user.getEmail());
            System.out.println("password: " + user.getPassword());
        }
    }
}
