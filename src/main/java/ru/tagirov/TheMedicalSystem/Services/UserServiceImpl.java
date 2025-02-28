package ru.tagirov.TheMedicalSystem.Services;

import lombok.AllArgsConstructor;
// import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.tagirov.TheMedicalSystem.Models.Role;
import ru.tagirov.TheMedicalSystem.Models.User;
import ru.tagirov.TheMedicalSystem.Repositories.*;

import java.util.Arrays;
import java.util.List;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService{
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    //private PasswordEncoder passwordEncoder;

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public void saveUser(User user) {
        Role role = roleRepository.findByName("ROLE_ADMIN");
        if(role == null){
            role = checkRoleExist();
        }
        user.setActive(true);
        user.setRoles(Arrays.asList(role));
        userRepository.save(user);
    }

    private Role checkRoleExist(){
        Role role = new Role();
        role.setName("ROLE_ADMIN");
        return roleRepository.save(role);
    }
}
