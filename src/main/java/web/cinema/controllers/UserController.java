package web.cinema.controllers;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import web.cinema.dto.UserResponseDto;
import web.cinema.models.User;
import web.cinema.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/inject")
    public String inject() {
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
        userService.add(user1);
        userService.add(user2);
        userService.add(user3);
        userService.add(user4);
        return "data was added";
    }

    @GetMapping("/{userId}")
    public UserResponseDto get(@PathVariable String userId) {
        UserResponseDto dto = new UserResponseDto();
        User user = userService.get(Long.valueOf(userId));
        dto.setEmail(user.getEmail());
        dto.setPassword(user.getPassword());
        return dto;
    }

    @RequestMapping
    public List<UserResponseDto> getAll() {
        List<User> users = userService.listUsers();
        List<UserResponseDto> usersDto = new ArrayList<>();
        for (User u : users) {
            UserResponseDto userResponseDto = new UserResponseDto();
            userResponseDto.setEmail(u.getEmail());
            userResponseDto.setPassword(u.getPassword());
            usersDto.add(userResponseDto);
        }
        return usersDto;
    }
}
