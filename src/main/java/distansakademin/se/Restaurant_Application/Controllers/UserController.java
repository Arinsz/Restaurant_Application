package distansakademin.se.Restaurant_Application.Controllers;


import distansakademin.se.Restaurant_Application.Entitys.User;
import distansakademin.se.Restaurant_Application.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/login")
    public String login() {
        return "login";
    }



    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("successMessage", null); // Add success message attribute to the model
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user, Model model) {
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        userService.save(user);
        model.addAttribute("successMessage", "User created successfully!"); // Add success message to the model
        return "register"; // Return to the registration page to display the success message
    }
}