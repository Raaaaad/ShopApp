package rad.shopapp.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import rad.shopapp.Modules.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    public Role findByName(String name);
}
