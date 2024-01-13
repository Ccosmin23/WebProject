package rentals.security;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final PasswordEncoder passwordEncoder;

    public CustomUserDetailsService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Replace the hard-coded values with actual user data from your database
        if ("user".equals(username)) {
            return new org.springframework.security.core.userdetails.User(
                    "cc",
                    passwordEncoder.encode("cc"),
                    Arrays.asList(new SimpleGrantedAuthority("USER"))
            );
        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }
}
