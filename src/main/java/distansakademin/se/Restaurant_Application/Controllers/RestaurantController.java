package distansakademin.se.Restaurant_Application.Controllers;

import distansakademin.se.Restaurant_Application.Entitys.Restaurant;
import distansakademin.se.Restaurant_Application.Services.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class RestaurantController {

    private final RestaurantService restaurantService;

    @Autowired
    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @GetMapping("/restaurants")
    public String getAllRestaurants(Model model) {
        List<Restaurant> restaurants = restaurantService.getAllRestaurants();
        model.addAttribute("restaurants", restaurants);
        return "restaurant"; // Assuming "restaurant" is the name of the view/template
    }

    @GetMapping("/restaurants/{id}")
    @ResponseBody
    public Restaurant getRestaurantById(@PathVariable Long id) {
        return restaurantService.getRestaurantById(id);
    }

    @PostMapping("/restaurants/add")
    public String addRestaurant(@RequestParam("name") String name, @RequestParam("address") String address,
                                @RequestParam("phone") String phone) {
        Restaurant newRestaurant = new Restaurant(name, address, phone);
        restaurantService.saveRestaurant(newRestaurant);
        return "redirect:/restaurants"; // Redirect to the list of restaurants
    }

    @PutMapping("/restaurants/{id}")
    @ResponseBody
    public String updateRestaurant(@PathVariable Long id, @RequestBody Restaurant restaurant) {
        restaurant.setId(id);
        restaurantService.saveRestaurant(restaurant);
        return "Restaurant updated successfully";
    }

    @DeleteMapping("/restaurants/{id}")
    @ResponseBody
    public String deleteRestaurant(@PathVariable Long id) {
        restaurantService.deleteRestaurant(id);
        return "Restaurant deleted successfully";
    }
}