package ru.tagirov.TheMedicalSystem.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.tagirov.TheMedicalSystem.Models.User;
import ru.tagirov.TheMedicalSystem.Services.UserServiceImpl;

@Controller
public class UserController {
    @Autowired
    private UserServiceImpl userService;


    @GetMapping("/profile")
    public String profile(Model model, Authentication authentication) {
        String email = authentication.getName();
        User user = userService.findUserByEmail(email);
        model.addAttribute("user", user);
        return "profile";
    }
}
