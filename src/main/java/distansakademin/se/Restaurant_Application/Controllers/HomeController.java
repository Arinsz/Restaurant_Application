package distansakademin.se.Restaurant_Application.Controllers;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {


    @GetMapping("/")
    public String home(Model model, @AuthenticationPrincipal UserDetails user) {
        model.addAttribute("username", user != null ? user.getUsername() : null);
        return "home";
    }



}