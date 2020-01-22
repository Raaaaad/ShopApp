package rad.shopapp.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import rad.shopapp.Modules.User;
import rad.shopapp.Repositories.RoleRepository;
import rad.shopapp.Repositories.UserRepository;

import java.util.Arrays;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public User RegisterUser(User user){
        if(userRepository.findByEmail(user.getEmail())!=null)
            return null;
        user.setActive(true);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(Arrays.asList(roleRepository.findByName("ROLE_USER")));
        userRepository.save(user);
        return user;
    }
}
