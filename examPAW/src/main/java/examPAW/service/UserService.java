package examPAW.service;

import org.springframework.stereotype.Service;
import examPAW.entity.UserEntity;
import examPAW.repository.UserRepository;

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
        UserEntity userEntity = userRepository.findByUsername(username);

        System.out.println("\nuser found with password = " + userEntity.getPassword() + "\n");

        return userEntity;
    }

    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

}
