package distansakademin.se.Restaurant_Application.Repositories;


import distansakademin.se.Restaurant_Application.Entitys.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}