package rentals.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rentals.persistence.User;

@RestController
@RequestMapping("/api/auth")
public class SignInController {

    private final UserService userService;

    public SignInController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping( "/login")
    public String login(@RequestBody User user) {
        User test = userService.findByUsername(user.getUsername());
        return test.getUsername();
    }

}
