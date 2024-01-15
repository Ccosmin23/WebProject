package rentals.service;

import org.springframework.stereotype.Service;
import rentals.entity.UserEntity;
import rentals.repository.UserRepository;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserEntity saveUser(UserEntity userEntity) {
        return userRepository.save(userEntity);
    }

    public UserEntity findByUsername(String username) {
        username = "cc";

        System.out.println("\nusername = " + username + "\n");

        UserEntity userEntity = userRepository.findByUsername("cc");

        System.out.println("\nuser found with password = " + userEntity.getPassword() + "\n");

        return userEntity;
    }

    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

}
