package sk.stuba.fei.uim.oop.assignment3.book;



import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private  String description;

    private Long author;

    private int amount;

    private int pages;

    private int lendCount;



}
