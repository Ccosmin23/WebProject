package rentals;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import rentals.entity.UserEntity;
import rentals.service.UserService;

import java.util.List;

@SpringBootApplication
@RestController
public class RentalsApplication {
    private final UserService userService;

    public RentalsApplication(UserService userService) {
        this.userService = userService;
    }

    public static void main(String[] args) {
        SpringApplication.run(RentalsApplication.class, args);
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }

    @GetMapping("/api/public/hello")
    public String hello2() {
        return "public Hello World";
    }

    @GetMapping("/api/private/dashboard")
    public String dashboard() {
        return "private dashboard";
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserEntity>> getAllUsers() {
        List<UserEntity> userEntities = userService.getAllUsers();
        return ResponseEntity.ok(userEntities);
    }
}
