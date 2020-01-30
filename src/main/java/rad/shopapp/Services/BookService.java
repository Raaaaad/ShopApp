package rad.shopapp.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rad.shopapp.Models.Book;
import rad.shopapp.Repositories.BookRepository;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;

    public Book getBookByTitle(String title){
        return bookRepository.findByTitle(title);
    }

}
