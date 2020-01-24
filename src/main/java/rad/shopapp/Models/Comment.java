package rad.shopapp.Models;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;

@Entity
public class Comment {
    @Id
    @GeneratedValue
    private int id;

    private String body;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate additionDate;
    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User user;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public LocalDate getAdditionDate() {
        return additionDate;
    }

    public void setAdditionDate(LocalDate additionDate) {
        this.additionDate = additionDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
