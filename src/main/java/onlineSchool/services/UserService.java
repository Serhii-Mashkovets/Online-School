package onlineSchool.services;

import onlineSchool.models.User;
import onlineSchool.persistanceObjects.UsersEntity;
import onlineSchool.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User findByUsername(String username) {
        UsersEntity userEntity = usersRepository.findByUsername(username);
        if (userEntity != null) {
            User user = new User();
            user.setId(userEntity.getId());
            user.setUsername(userEntity.getUsername());
            user.setPassword(userEntity.getPassword());
            user.setEmail(userEntity.getEmail());
            user.setRole(userEntity.getRole());
            user.setEnabled(userEntity.isEnabled());
            return user;
        } else {
            return null;
        }
    }

    public void saveUser(User user) {
        UsersEntity userEntity = new UsersEntity();
        userEntity.setUsername(user.getUsername());
        userEntity.setPassword(passwordEncoder.encode(user.getPassword()));
        userEntity.setEmail(user.getEmail());
        userEntity.setRole(user.getRole());
        userEntity.setEnabled(true);
        usersRepository.save(userEntity);
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UsersEntity userEntity = usersRepository.findByUsername(username);
        if (userEntity != null) {
            org.springframework.security.core.userdetails.User.UserBuilder builder = org.springframework.security.core.userdetails.User.withUsername(username);
            builder.password(userEntity.getPassword());
            builder.authorities(String.valueOf(userEntity.getRole()));
            builder.disabled(!userEntity.isEnabled());
            return builder.build();
        } else {
            throw new UsernameNotFoundException("User not found");
        }
    }

    public Iterable<UsersEntity> getAllUsers() {
        Iterable<UsersEntity> allUsers = usersRepository.findAll();
        return allUsers;
    }
}
