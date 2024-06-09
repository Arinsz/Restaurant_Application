package distansakademin.se.Restaurant_Application.Controllers;

import distansakademin.se.Restaurant_Application.Entitys.Restaurant;
import distansakademin.se.Restaurant_Application.Entitys.Review;
import distansakademin.se.Restaurant_Application.Entitys.User;
import distansakademin.se.Restaurant_Application.Services.RestaurantService;
import distansakademin.se.Restaurant_Application.Services.ReviewService;
import distansakademin.se.Restaurant_Application.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @Autowired
    private UserService userService;

    @Autowired
    private RestaurantService restaurantService;

    @GetMapping("/reviews")
    public String listReviews(Model model) {
        model.addAttribute("reviews", reviewService.getAllReviews());
        return "reviews";
    }

    @PostMapping("/reviews/add")
    public String addReview(@RequestParam Long restaurantId, @RequestParam int rating, @RequestParam String comment) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            User user = userService.getUserByUsername(authentication.getName());
            Restaurant restaurant = restaurantService.getRestaurantById(restaurantId);
            Review review = new Review(user, restaurant, rating, comment);
            reviewService.saveReview(review);
        }
        return "redirect:/restaurants";
    }
    // Other controller methods as needed
}