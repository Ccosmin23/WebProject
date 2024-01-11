package rentals.controller;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rentals.persistence.User;
import rentals.service.UserService;

@RestController
@RequestMapping("/api/login")
public class SignInController implements UserDetailsService {

    private final UserService userService;

    public SignInController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public String login(@RequestBody User user) {
        UserDetails userDetails = loadUserByUsername(user.getUsername());
        // Implement your authentication logic here
        // For simplicity, you can compare the provided password with the one stored in the database
        if (userDetails != null && user.getPassword().equals(userDetails.getPassword())) {
            return "Login successful";
        } else {
            return "Login failed";
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        return org.springframework.security.core.userdetails.User
                .withUsername(username)
                .password(user.getPassword())
                .roles("USER")
                .build();
    }
}
