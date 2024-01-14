package rentals.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import rentals.service.UserService;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/public/auth")
public class SignInController {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    public SignInController(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @Autowired
    private UserDetailsService userDetailsService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestParam("username") String username, @RequestParam("password") String password) {
        System.out.println("\n ------ajunge me aici");
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);

        if (passwordEncoder.matches(password, userDetails.getPassword())) {
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
