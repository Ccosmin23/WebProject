package rentals.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/public/auth")
public class SignInController {

    private final UserService userService;

    public SignInController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public ResponseEntity<?> login() {
        return ResponseEntity.ok().body("{\"message\":\"Home1\"}");
    }

    @PostMapping("/login")
    public ResponseEntity<?> handleLogin(@RequestParam("username") String username, @RequestParam("password") String password) {
        // Handle login logic here
        return ResponseEntity.ok().body("{\"message\":\"Home\"}");
    }

}
