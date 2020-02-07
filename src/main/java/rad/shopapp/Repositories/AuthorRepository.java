package rad.shopapp.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import rad.shopapp.Models.Author;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
    Author findByLastName(String lastName);
}
