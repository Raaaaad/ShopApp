package rad.shopapp.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import rad.shopapp.Modules.User;

public interface UserRepository extends JpaRepository<User, Integer> {
}
