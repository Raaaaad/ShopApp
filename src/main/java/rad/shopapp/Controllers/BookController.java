package rad.shopapp.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rad.shopapp.Models.Book;
import rad.shopapp.Services.BookService;

@RestController
public class BookController {
    @Autowired
    BookService bookService;

    @RequestMapping(value = "/book/{title}", method = RequestMethod.GET)
    public Book getBookByTitle(@PathVariable String title){
        return bookService.getBookByTitle(title);
    }

}
