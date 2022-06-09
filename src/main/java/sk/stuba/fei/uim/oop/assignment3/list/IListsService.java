package sk.stuba.fei.uim.oop.assignment3.list;

import sk.stuba.fei.uim.oop.assignment3.book.BookIdRequest;


import java.util.List;

public interface IListsService {
    List<Lists> getAll();
    Lists create();
    Lists getListById(Long id);
    void deleteListById(Long id);
    Lists addBookToList(Long id, BookIdRequest request);
    void lendLendingListById(Long id);
    void removeBookFromListById(Long id, BookIdRequest request);
}
