package rad.shopapp.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rad.shopapp.Jwt.JwtUtil;
import rad.shopapp.Models.Book;
import rad.shopapp.Models.User;
import rad.shopapp.Repositories.BookRepository;
import rad.shopapp.Repositories.UserRepository;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;

    @Autowired
    private JwtUtil jwtTokenUtil;

    @Autowired
    private UserRepository userRepository;


    public Book GetBookByTitle(String title){
        return bookRepository.findByTitle(title);
    }

    public Book AddToRead(String title, HttpServletRequest httpServletRequest) throws Exception{
        String authorizationHeader = httpServletRequest.getHeader("Authorization");
        if(authorizationHeader==null)
            throw new Exception("No token!");
        String jwt = authorizationHeader;
        String email = jwtTokenUtil.extractEmail(jwt);
        User user = userRepository.findByEmail(email);
        Book book = bookRepository.findByTitle(title);
        if(user.getBooks().contains(book))
           throw new Exception("User has that book!");
        Collection<Book> books = user.getBooks();
        books.add(book);

        Collection<User> users = book.getUsers();
        users.add(user);

        user.setBooks(books);
        book.setUsers(users);

        userRepository.save(user);
        bookRepository.save(book);

        return book;
    }

}
