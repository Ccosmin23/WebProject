package rentals;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import rentals.entity.UserEntity;
import rentals.service.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

    @GetMapping("/all")
    public ResponseEntity<List<UserEntity>> getAllUsers() {
        List<UserEntity> userEntities = userService.getAllUsers();
        return ResponseEntity.ok(userEntities);
    }

    // o sa folosim /lista pentru afișarea datelor din tabela SQL
    @GetMapping("/lista")
    public String afisareDate() {
        return "Hello World";
    }

    // o sa folosim /update pentru inserarea datelor preluate din API-ul extern
    @PostMapping("/update")
    public String inserareDate() {
        return "Hello World";
    }

    // o sa folosim /item/{id} pentru furnizarea datelor corespunzătoare unei înregistrări din BD
    @PostMapping("/item/{id}")
    public String furnizareDate() {
        return "Hello World";
    }
}
