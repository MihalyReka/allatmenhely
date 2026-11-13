package allatmenhelyNyilvantartas.allatMenhely.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final FelhasznaloDetailService felhasznaloDetailService;

    public SecurityConfig(FelhasznaloDetailService felhasznaloDetailService) {
        this.felhasznaloDetailService = felhasznaloDetailService;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()).userDetailsService(felhasznaloDetailService)
                .authorizeHttpRequests(auth->auth
                        .requestMatchers("/api/felhasznalok/regisztracio")
                            .permitAll()

                        .requestMatchers("/api/animals/public/**")
                            .permitAll()

                        .requestMatchers("/api/animals/**")
                            .hasAnyRole("DOLGOZO", "ADMIN")

                        .requestMatchers("/api/befogado/sajat")
                            .hasAnyRole("BEFOGADO","ADMIN")

                        .requestMatchers("/api/befogado/**")
                            .hasAnyRole("DOLGOZO", "ADMIN")

                        .requestMatchers("/api/dolgozo/sajat")
                        .hasAnyRole("DOLGOZO","ADMIN")

                        .requestMatchers("/api/dolgozo/**").hasRole("ADMIN")

                        .requestMatchers("/api/gond-allat-kapcs/**")
                            .hasAnyRole("DOLGOZO", "ADMIN")

                        .requestMatchers("/api/felhasznalok/**").hasRole("ADMIN")

                        .anyRequest().authenticated())
                .httpBasic(basic->{});
        return http.build();

    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
