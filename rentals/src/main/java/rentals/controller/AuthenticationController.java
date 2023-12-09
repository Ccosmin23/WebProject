package rentals.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import rentals.model.LoginRequest;
import rentals.persistance.User;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

    @PostMapping("/login")
    public ResponseEntity<String> login(LoginRequest loginRequest) {
        String email = loginRequest.getEmail();
        String password = loginRequest.getPassword();

        User user = new User();
        user.setEmail(email);
        user.setPassword(password); // In practice, you'd hash the password first

//        userRepository.save(user);

        return ResponseEntity.ok("Login successful");
    }
}
