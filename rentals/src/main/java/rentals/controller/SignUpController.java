package rentals.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rentals.persistence.User;
import rentals.service.UserService;

@RestController
@RequestMapping("/api/auth")
public class SignUpController {

    private final UserService userService;

    public SignUpController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/register")
    public void registerUser(@RequestBody User user) {
        userService.saveUser(user);
    }
}
