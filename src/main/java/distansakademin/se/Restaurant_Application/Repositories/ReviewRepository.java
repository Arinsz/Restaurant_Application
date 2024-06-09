package distansakademin.se.Restaurant_Application.Repositories;


import distansakademin.se.Restaurant_Application.Entitys.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}