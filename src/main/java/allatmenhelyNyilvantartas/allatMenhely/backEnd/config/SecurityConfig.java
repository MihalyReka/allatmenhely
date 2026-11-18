package allatmenhelyNyilvantartas.allatMenhely.backEnd.config;

import allatmenhelyNyilvantartas.allatMenhely.backEnd.config.JwtAuthenticationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.http.HttpMethod;
import java.util.List;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtAuthenticationFilter;


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .cors(Customizer.withDefaults())
                .csrf(csrf -> csrf.disable())
                .headers(headers ->
                        headers.frameOptions(frame -> frame.sameOrigin())
                )
                .sessionManagement(session ->
                        session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )
                .authorizeHttpRequests(auth -> auth

                        .requestMatchers("/api/felhasznalok/regisztracio")
                        .permitAll()

                        .requestMatchers("/api/auth/login")
                        .permitAll()

                        .requestMatchers(HttpMethod.GET, "/api/animals", "/api/animals/**")
                        .permitAll()

                        .requestMatchers(HttpMethod.POST, "/api/animals/**")
                        .hasAnyRole("DOLGOZO", "ADMIN")

                        .requestMatchers(HttpMethod.PUT, "/api/animals/**")
                        .hasAnyRole("DOLGOZO", "ADMIN")

                        .requestMatchers(HttpMethod.DELETE, "/api/animals/**")
                        .hasAnyRole("DOLGOZO", "ADMIN")

                        .requestMatchers(HttpMethod.GET, "/api/befogado/sajat")
                        .hasAnyRole("BEFOGADO", "ADMIN")

                        .requestMatchers(HttpMethod.GET, "/api/befogado", "/api/befogado/**")
                        .hasAnyRole("DOLGOZO", "ADMIN")

                        .requestMatchers(HttpMethod.POST, "/api/befogado")
                        .hasRole("ADMIN")

                        .requestMatchers(HttpMethod.PUT, "/api/befogado/**")
                        .hasRole("ADMIN")

                        .requestMatchers(HttpMethod.DELETE, "/api/befogado/**")
                        .hasRole("ADMIN")

                        .requestMatchers("/api/befogado/**")
                        .hasAnyRole("DOLGOZO", "ADMIN")

                        .requestMatchers("/api/dolgozo/sajat")
                        .hasAnyRole("DOLGOZO", "ADMIN")

                        .requestMatchers("/api/dolgozo/**")
                        .hasRole("ADMIN")

                        .requestMatchers("/api/gond-allat-kapcs/**")
                        .hasAnyRole("DOLGOZO", "ADMIN")

                        .requestMatchers("/api/felhasznalok/**")
                        .hasRole("ADMIN")

                        .requestMatchers("/h2/**")
                        .hasRole("ADMIN")

                        .anyRequest().authenticated()
                )
                .addFilterBefore(
                        jwtAuthenticationFilter,
                        UsernamePasswordAuthenticationFilter.class
                );

        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration configuration
    ) throws Exception {
        return configuration.getAuthenticationManager();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();

        configuration.setAllowedOrigins(List.of("http://localhost:5173"));
        configuration.setAllowedMethods(
                List.of("GET", "POST", "PUT", "DELETE", "OPTIONS")
        );
        configuration.setAllowedHeaders(
                List.of("Authorization", "Content-Type")
        );
        configuration.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source =
                new UrlBasedCorsConfigurationSource();

        source.registerCorsConfiguration("/**", configuration);

        return source;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}