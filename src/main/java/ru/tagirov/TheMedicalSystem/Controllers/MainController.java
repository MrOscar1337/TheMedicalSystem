package ru.tagirov.TheMedicalSystem.Controllers;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.tagirov.TheMedicalSystem.Models.Person;
import ru.tagirov.TheMedicalSystem.Models.User;
import ru.tagirov.TheMedicalSystem.Services.PersonServiceImpl;
import ru.tagirov.TheMedicalSystem.Services.UserServiceImpl;

import java.util.List;


@AllArgsConstructor
@Controller
public class MainController {
    private PersonServiceImpl personService;
    private UserServiceImpl userService;


    @GetMapping("/")
    public String home (Model model){
        model.addAttribute("title", "Главная страница");
        return "main";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model){
        model.addAttribute("person", new Person());
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register/save")
    public String registration(@Valid @ModelAttribute("person") Person person,
                               @Valid @ModelAttribute("user") User user,
                               BindingResult result, Model model){
         User existingUser = userService.findUserByEmail(user.getEmail());

        if(existingUser != null && existingUser.getEmail() != null && !existingUser.getEmail().isEmpty()){
            result.rejectValue("email", null,
                    "Пользователь с такой электронной почтой уже зарегистрирован");
        }

        if(result.hasErrors()){
            model.addAttribute("user", user);
            model.addAttribute("person", person);
            return "/register";
        }

        personService.savePerson(person);
        userService.saveUser(user);
        return "redirect:/";
    }

    @GetMapping("/users")
    public String users(Model model){
        List<User> users = userService.findAllUsers();
        model.addAttribute("users", users);
        return "users";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }
}
