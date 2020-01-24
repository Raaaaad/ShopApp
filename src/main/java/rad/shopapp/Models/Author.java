package rad.shopapp.Models;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Author {
    @Id
    @GeneratedValue
    private int id;

    private String firstName;
    private String lastName;

    @ManyToMany
    @JoinTable(
            joinColumns = @JoinColumn(
                    name = "author_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "book_id", referencedColumnName = "id")
    )
    private Collection<Book> books;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Collection<Book> getBooks() {
        return books;
    }

    public void setBooks(Collection<Book> books) {
        this.books = books;
    }
}
