package rentals.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rentals.service.UserService;

import java.util.ArrayList;
import java.util.Map;

@RestController
@RequestMapping("/api/public/auth")
public class SignInController {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    public SignInController(UserService userService, PasswordEncoder passwordEncoder/*, UserDetailsService userDetailsService*/) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
//        this.userDetailsService = userDetailsService;
    }

//    private final UserDetailsService userDetailsService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> loginData) {
        System.out.println("\n ------ajunge pe aici");

        String username = loginData.get("username");
        String password = loginData.get("password");

        if (passwordEncoder.matches(password, userService.findByUsername(username).getPassword())) {
            // Credentials are correct, perform authentication
            Authentication auth = new UsernamePasswordAuthenticationToken(username, password, new ArrayList<>());
            SecurityContextHolder.getContext().setAuthentication(auth);
            return ResponseEntity.ok().body("{\"message\":\"Login successful\"}");
        } else {
            // Credentials are incorrect
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("{\"message\":\"Invalid username or password\"}");
        }
    }
}
