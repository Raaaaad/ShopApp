package rad.shopapp.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import rad.shopapp.Models.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {
   public Book findByTitle(String title);
}
