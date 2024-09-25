package pl.bialek.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CarDealershipUserDetailsService implements UserDetailsService {

    private final UserJpaRepository userJpaRepository;
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        UserEntity user = userJpaRepository.findByUserName(userName);
        List<GrantedAuthority> authorities = getUserAuthority(user.getAuthorities());
        return buildUserForAuthentication(user, authorities);
    }


    private List<GrantedAuthority> getUserAuthority(Set<AuthorityEntity> userAuthority) {
        return userAuthority.stream()
                .map(authority -> new SimpleGrantedAuthority(authority.getAuthority()))
                .distinct()
                .collect(Collectors.toList());
    }

    private UserDetails buildUserForAuthentication(UserEntity user, List<GrantedAuthority> authorities) {
        return new User(
                user.getUserName(),
                user.getPassword(),
                user.getActive(),
                true,
                true,
                true,
                authorities
        );
    }
}
