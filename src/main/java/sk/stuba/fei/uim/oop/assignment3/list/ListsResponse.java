package sk.stuba.fei.uim.oop.assignment3.list;

import lombok.Getter;
import sk.stuba.fei.uim.oop.assignment3.book.Book;

import javax.persistence.OneToMany;
import java.util.List;

@Getter
public class ListsResponse {
    private Long id;

    @OneToMany
    private List<Book> lendingList;

    private boolean lended;

    public ListsResponse(Lists l){

        this.id = l.getId();
        this.lendingList = l.getLendingList();
        this.lended = l.isLended();
    }
}