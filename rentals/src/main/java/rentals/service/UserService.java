package rentals.service;

import org.springframework.stereotype.Service;
import rentals.persistence.User;
import rentals.repository.UserRepository;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public User findByUsername(String username) {
        username = "cc";

        System.out.println("\nusername = " + username + "\n");

        User user = userRepository.findByUsername("cc");

        System.out.println("\nuser found with password = " + user.getPassword() + "\n");

        return user;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

}
