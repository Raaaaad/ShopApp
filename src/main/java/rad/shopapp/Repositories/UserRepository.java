package rad.shopapp.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import rad.shopapp.Models.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    public User findByEmail(String email);
}
