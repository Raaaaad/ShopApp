package rad.shopapp.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import rad.shopapp.Models.Privilege;

public interface PrivilegeRepository extends JpaRepository<Privilege, Integer> {
}
