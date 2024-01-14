package rentals.service;

import org.springframework.stereotype.Service;
import rentals.persistence.User;
import rentals.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;
//    private final BCryptPasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
//        this.passwordEncoder = passwordEncoder;
    }

    public User saveUser(User user) {
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public User findByUsername(String username) {
        System.out.println("\nusername = " + username + "\n");

        User user = userRepository.findByUsername(username);

        System.out.println("\nuser found with password = " + user.getPassword() + "\n");

        return user;
    }

}
