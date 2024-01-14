package rentals.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import rentals.persistence.User;
import rentals.service.CustomUserDetailsService;
import rentals.service.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/public/auth")
public class SignInController {
    private final CustomUserDetailsService userDetailsService;
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    public SignInController(PasswordEncoder passwordEncoder, CustomUserDetailsService userDetailsService, UserService userService) {
        this.passwordEncoder = passwordEncoder;
        this.userDetailsService = userDetailsService;
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> loginData) {
        String username = loginData.get("username");
        String password = loginData.get("password");

        System.out.println("\n username = " + username);
        System.out.println("\n password = " + password);

        try {
            UserDetails userDetails = userDetailsService.loadUserByUsername("cc");
            // ... continue with authentication ...

            if (userDetails.getUsername() == null || userDetails.getUsername().trim().isEmpty() || userDetails.getPassword() == null || userDetails.getPassword().trim().isEmpty()) {
                return ResponseEntity.badRequest().body("{\"message\":\"Username or password is empty\"}");
            }

            // Encode the password
            String encodedPassword = passwordEncoder.encode(userDetails.getPassword());

            Authentication auth = new UsernamePasswordAuthenticationToken(userDetails.getUsername(), encodedPassword, new ArrayList<>());
            SecurityContextHolder.getContext().setAuthentication(auth);
            return ResponseEntity.ok().body("{\"message\":\"Login successful\"}");


        } catch (UsernameNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"message\":\"User not found\"}");
        }


    }


    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userDetailsService.loadAllUsers();
        return ResponseEntity.ok(users);
    }




}
