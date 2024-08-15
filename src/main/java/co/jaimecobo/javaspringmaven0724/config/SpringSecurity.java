package co.jaimecobo.javaspringmaven0724.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Configuration
public class SpringSecurity {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        // Boilerplate code to protect a common hack
        http.csrf(csrf -> csrf.disable());

        // This section allows all pages EXCEPT the ones that are in the AntPathRequestMatcher
        // Anything in AntPathRequestMatcher will require the user authentication
        http.authorizeRequests()
                .requestMatchers
            (
            new AntPathRequestMatcher("/admin/**"),
            new AntPathRequestMatcher("/city/**"),
            new AntPathRequestMatcher("/user/all-users"),
            new AntPathRequestMatcher("/user/users-by-name"),
            new AntPathRequestMatcher("/user/users-by-city"),
            new AntPathRequestMatcher("/user/user/**"),
            new AntPathRequestMatcher("/event/**")
            ).authenticated()
            .anyRequest().permitAll();

        // The loginPage parameter is the actual URL of the login page
        // The loginProcessingUrl is the URL that the form will submit to
        http.formLogin(formLogin -> formLogin
                .loginPage("/account/loginPageUrl")
                // This URL is part of Spring Security
                .loginProcessingUrl("/account/loginProcessingURL")
        );

        // this is the URL that will log a user out
        http.logout(formLogout -> formLogout
                .invalidateHttpSession(true)
                .logoutUrl("/account/logout")
                        .logoutSuccessUrl("/")
        );

        return http.build();

    }

    @Bean(name = "passwordEncoder")
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }

}