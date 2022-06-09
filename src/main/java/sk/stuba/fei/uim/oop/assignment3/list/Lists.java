package sk.stuba.fei.uim.oop.assignment3.list;

import lombok.Data;
import sk.stuba.fei.uim.oop.assignment3.book.Book;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Lists  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany
    private List<Book> lendingList;

    private boolean lended;


    public Lists() {
        this.lendingList = new ArrayList<>();
        this.lended = true;
    }
}