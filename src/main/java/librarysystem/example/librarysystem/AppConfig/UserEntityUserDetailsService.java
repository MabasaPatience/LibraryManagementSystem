package librarysystem.example.librarysystem.AppConfig;

import librarysystem.example.librarysystem.Entity.Role;
import librarysystem.example.librarysystem.Entity.UserEntity;
import librarysystem.example.librarysystem.Repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
@Slf4j
@Service
public class UserEntityUserDetailsService implements UserDetailsService {
    @Autowired
    public UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity= userRepository.findByEmail(username);
        log.info(userEntity.getEmail());
        if(!Objects.isNull(userEntity)) {
            log.info(userEntity.getRole().get(0).getName());
            return new User(userEntity.getEmail(), userEntity.getPassword(), mapAuthorities(userEntity.getRole()));
        }else {
            throw new UsernameNotFoundException("user not found");
        }

    }
    public Collection<GrantedAuthority> mapAuthorities(List<Role> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }
}
