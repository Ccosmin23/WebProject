package rentals;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EntityScan(basePackages = "rentals.persistence")
@EnableJpaRepositories(basePackages = "rentals.repository")
public class RentalsApplication {
    public static void main(String[] args) {
        SpringApplication.run(RentalsApplication.class, args);
    }
}


//    @RequestMapping(value = "/test1")
//    public String test() {
//        return "hello from the other side";
//    }

