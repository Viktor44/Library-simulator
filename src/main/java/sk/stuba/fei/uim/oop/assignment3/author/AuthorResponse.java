package sk.stuba.fei.uim.oop.assignment3.author;

import lombok.Getter;

import javax.persistence.ElementCollection;
import java.util.List;


@Getter
public class AuthorResponse {
    private Long id;

    private String name;

    private String surname;


    @ElementCollection
    private List<Long> books;

    AuthorResponse(Author a) {
        this.id = a.getId();
        this.name = a.getName();
        this.surname = a.getSurname();
        this.books = a.getBooks();


    }
}
