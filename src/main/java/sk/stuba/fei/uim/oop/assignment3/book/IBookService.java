package sk.stuba.fei.uim.oop.assignment3.book;

import java.util.List;

public interface IBookService {
    List<Book> getAll();
    Book create(BookRequest request);
    Book getBookById(Long id);
    Book addBookToAuthor(Long animalId, Long personId);
    Book updateBookById(Long bookId, BookRequest request);
    void deleteBookById(Long bookId);
    BookAmount getBookAmountById(Long bookId);
    BookAmount updateBookAmountById(Long bookId, BookAmount amount);
    BookAmount getBookLendCountById(Long bookId);
}
