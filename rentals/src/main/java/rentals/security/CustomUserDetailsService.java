package rentals.security;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import rentals.controller.UserService;

import java.util.Arrays;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    public CustomUserDetailsService(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Replace the hard-coded values with actual user data from your database


        if ("cc".equals(username)) {
            return new org.springframework.security.core.userdetails.User(
                    username,
                    passwordEncoder.encode("cc"),
                    Arrays.asList(new SimpleGrantedAuthority("USER"))
            );
        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }
}
