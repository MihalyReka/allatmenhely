package allatmenhelyNyilvantartas.allatMenhely.config;


import allatmenhelyNyilvantartas.allatMenhely.data.entity.FelhasznaloEnti;
import allatmenhelyNyilvantartas.allatMenhely.data.repository.FelhasznaloRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FelhasznaloDetailService implements UserDetailsService {

    private final FelhasznaloRepo felhasznaloRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        FelhasznaloEnti felhasznalo=felhasznaloRepo.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("A felhasznalonév nem találhato." + username));
        return User.builder()
                .username(felhasznalo.getUsername())
                .password(felhasznalo.getPassword())
                .roles(felhasznalo.getRole().name())
                .build();
    }
}
