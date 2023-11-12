package rentals;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class RentalsApplication {

    public static void main(String[] args) {
        SpringApplication.run(RentalsApplication.class, args);
    }

    @RequestMapping(value = "/test1")
    public String test() {
        return "hello from the other side";
    }
}
