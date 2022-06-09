package sk.stuba.fei.uim.oop.assignment3.book;

import lombok.Getter;

@Getter
public class BookResponse {
    private Long id;

    private String name;

    private  String description;

    private Long author;

    private int amount;

    private int pages;


    private int lendCount;

    BookResponse(Book b) {
        this.id = b.getId();
        this.name = b.getName();
        this.description = b.getDescription();
        this.author = b.getAuthor();
        this.pages = b.getPages();
        this.amount = b.getAmount();
        this.lendCount = b.getLendCount();

    }

}
