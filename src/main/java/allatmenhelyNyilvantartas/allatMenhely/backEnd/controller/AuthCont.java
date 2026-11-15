package allatmenhelyNyilvantartas.allatMenhely.backEnd.controller;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthCont {
    @GetMapping("/me")
    public Map<String, String> getCurrentUser(
            Authentication authentication) {

        String role = authentication.getAuthorities()
                .stream()
                .findFirst()
                .map(GrantedAuthority::getAuthority)
                .orElse("");

        role = role.replace("ROLE_", "");

        return Map.of(
                "username", authentication.getName(),
                "role", role
        );
    }
}
