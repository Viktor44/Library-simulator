package sk.stuba.fei.uim.oop.assignment3.author;


import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Data
@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String surname;


    @ElementCollection
    private List<Long> books ;

    public Author(){
        this.books = new ArrayList<>();
    }


}
