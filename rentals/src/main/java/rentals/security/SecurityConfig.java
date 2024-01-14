package rentals.security;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.OrRequestMatcher;
import org.springframework.security.web.util.matcher.RegexRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

import java.io.IOException;
import java.io.PrintWriter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        RequestMatcher publicMatcher = new RegexRequestMatcher("/all", null);
        RequestMatcher helloMatcher = new RegexRequestMatcher("/api/public/auth/all", null);
        RequestMatcher helloMatcher2 = new RegexRequestMatcher("/api/public/auth/login", null);
        RequestMatcher combinedMatcher = new OrRequestMatcher(publicMatcher, helloMatcher, helloMatcher2);

        http
                .csrf(csrf -> csrf.disable())
                .authorizeRequests()
                .requestMatchers(combinedMatcher).permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin(
                        form -> form
                                .loginPage("/hello")
                                .loginProcessingUrl("/api/public/auth/login2")
                                .defaultSuccessUrl("/api/private/dashboard")
//                                .failureHandler(myAuthenticationFailureHandler())
                                .permitAll()
                )
                .logout(
                        logout -> logout
                                .logoutRequestMatcher(new AntPathRequestMatcher("/api/auth/logout"))
                                .permitAll()
                                .invalidateHttpSession(true)
                                .deleteCookies("JSESSIONID")
                );
        return http.build();
    }

    @Bean
    public AuthenticationFailureHandler myAuthenticationFailureHandler() {
        return new SimpleUrlAuthenticationFailureHandler() {
            @Override
            public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                PrintWriter writer = response.getWriter();
                writer.write("{\"message\":\"Invalid username or password\"}");
                writer.flush();
            }

//            @Override
//            public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
//                // Custom logic here
//                System.out.println("\n =====\nin cauzul in care verm sa trimitem un status code sau sa facem altceva pe failure\n");
////                response.sendRedirect("/hello");
//            }
        };
    }


}
