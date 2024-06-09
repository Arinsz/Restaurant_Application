package distansakademin.se.Restaurant_Application.Repositories;


import distansakademin.se.Restaurant_Application.Entitys.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
}