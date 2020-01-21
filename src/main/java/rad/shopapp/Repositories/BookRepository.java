package rad.shopapp.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import rad.shopapp.Modules.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {
    Book findByTitle(String title);
}
