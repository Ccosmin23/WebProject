//package rentals.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//import rentals.persistence.User;
//import rentals.repository.UserRepository;
//
//import java.util.Collections;
//import java.util.List;
//
//@Service
//public class CustomUserDetailsService implements UserDetailsService {
//    @Autowired
//    private final UserRepository userRepository;
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    public CustomUserDetailsService(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        if (username == null || username.trim().isEmpty()) {
//            throw new UsernameNotFoundException("Username is empty or null");
//        }
//
//        User user = userRepository.findByUsername("cc");
//
//        if (user == null) {
//            throw new UsernameNotFoundException("User not found");
//        }
//
//        String password = user.getPassword();
//        if (password == null) {
//            throw new UsernameNotFoundException("Password not set for the user");
//        }
//
//        return new org.springframework.security.core.userdetails.User(
//                user.getUsername(),
//                password,
//                Collections.emptyList()
//        );
//    }
//
//
//    public List<User> loadAllUsers() {
//        return this.userRepository.findAll();
//    }
//
//}
