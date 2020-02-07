package rad.shopapp.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rad.shopapp.Models.Book;
import rad.shopapp.Services.BookService;

import javax.servlet.http.HttpServletRequest;

@RestController
public class BookController {
    @Autowired
    BookService bookService;

    @RequestMapping(value = "/book/{title}", method = RequestMethod.GET)
    public Book GetBookByTitle(@PathVariable String title){
        return bookService.GetBookByTitle(title);
    }

    @RequestMapping(value = "/book/{title}", method = RequestMethod.POST)
    public Book AddToRead(@PathVariable String title, HttpServletRequest httpRequest){
        return bookService.AddToRead(title, httpRequest);
    }
}
