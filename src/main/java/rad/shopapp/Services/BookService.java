package rad.shopapp.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import rad.shopapp.Repositories.BookRepository;

@RestController
public class BookService {
    @Autowired
    BookRepository bookRepository;
}
