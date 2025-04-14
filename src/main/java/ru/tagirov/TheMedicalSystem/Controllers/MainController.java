package ru.tagirov.TheMedicalSystem.Controllers;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.tagirov.TheMedicalSystem.Models.*;
import ru.tagirov.TheMedicalSystem.Repositories.RoleRepository;
import ru.tagirov.TheMedicalSystem.Security.RegistrationDTO;
import ru.tagirov.TheMedicalSystem.Services.*;

import java.util.Collections;
import java.util.Date;


@AllArgsConstructor
@Controller
public class MainController {
    private static final Logger logger = LoggerFactory.getLogger(MainController.class);

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private PersonServiceImpl personService;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("title", "Главная страница");
        return "main";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new RegistrationDTO());
        return "register";
    }

    @PostMapping("/register")
    public String registration(@ModelAttribute("user") @Valid RegistrationDTO dto,
                               BindingResult result) {
        logger.info("Registration attempt with email: {}", dto.getEmail());

        if (userService.existsByEmail(dto.getEmail())) {
            logger.warn("Email already exists: {}", dto.getEmail());
            result.rejectValue("email", "error.email", "Email already exists");
        }

        if (result.hasErrors()) {
            logger.warn("Validation errors: {}", result.getAllErrors());
            return "register";
        }

        try {

            User user = new User();
            user.setEmail(dto.getEmail());
            user.setPassword(passwordEncoder.encode(dto.getPassword()));
            user.setActive(true);
            user.setRegistration(new Date());


            Role userRole = roleRepository.findByName("USER")
                    .orElseGet(() -> {
                        Role newRole = new Role();
                        newRole.setName("USER");
                        return roleRepository.save(newRole);
                    });

            user.setRoles(Collections.singletonList(userRole));

            Passport passport = new Passport();
            passport.setSeries(dto.getPassportSeries());
            passport.setNumber(dto.getPassportNumber());
            passport.setIssue(dto.getPassportIssue());

            Address address = new Address();
            address.setRegion(dto.getRegion());
            address.setCity(dto.getCity());
            address.setStreet(dto.getStreet());
            address.setHouse(dto.getHouse());
            address.setFlat(dto.getFlat());
            address.setFact(dto.isFact());

            Person person = new Person();
            person.setName(dto.getName());
            person.setSurname(dto.getSurname());
            person.setPatronymic(dto.getPatronymic());
            person.setBirth(dto.getBirth());
            person.setGender(dto.getGender());


            person.setUser(user);
            person.setPassport(passport);
            person.setAddress(address);


            personService.savePerson(person);
            logger.info("User registered successfully: {}", dto.getEmail());
            return "redirect:/";
        } catch (Exception e) {
            logger.error("Error during registration: {}", e.getMessage(), e);
            return "register";
        }
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
}