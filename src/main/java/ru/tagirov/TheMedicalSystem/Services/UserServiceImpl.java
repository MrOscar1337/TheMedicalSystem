package ru.tagirov.TheMedicalSystem.Services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.tagirov.TheMedicalSystem.Models.*;
import ru.tagirov.TheMedicalSystem.Repositories.PersonRepository;
import ru.tagirov.TheMedicalSystem.Repositories.RoleRepository;
import ru.tagirov.TheMedicalSystem.Repositories.UserRepository;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository,
                           RoleRepository roleRepository,
                           PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void saveUser(UserDto userDto) {
        User user = new User();

        user.setEmail(userDto.getEmail());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));

        Role role = roleRepository.findByName("ROLE_ADMIN");
        if(role == null){
            role = checkRoleExist();
        }
        user.setRoles(Arrays.asList(role));

        Address address = new Address();
        address.setRegion(userDto.getRegion());
        address.setCity(userDto.getCity());
        address.setStreet(userDto.getStreet());
        address.setHouse(userDto.getHouse());
        address.setFlat(userDto.getFlat());
        address.setFact(userDto.isFact());

        Passport passport = new Passport();
        passport.setSeries(userDto.getPassportSeries());
        passport.setNumber(userDto.getPassportNumber());
        passport.setIssue(userDto.getPassportIssue());

        Person person = new Person();
        person.setName(userDto.getName());
        person.setSurname(userDto.getSurname());
        person.setPatronymic(userDto.getPatronymic());
        person.setBirth(userDto.getBirth());
        person.setGender(userDto.getGender());
        person.setUser(user);
        person.setAddress(address);
        person.setPassport(passport);
        personRepository.save(person);
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public List<UserDto> findAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map((user) -> mapToUserDto(user))
                .collect(Collectors.toList());
    }

    private UserDto mapToUserDto(User user){
        UserDto userDto = new UserDto();
        userDto.setEmail(user.getEmail());
        return userDto;
    }

    private Role checkRoleExist(){
        Role role = new Role();
        role.setName("ROLE_ADMIN");
        return roleRepository.save(role);
    }
}
