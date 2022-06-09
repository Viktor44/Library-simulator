package sk.stuba.fei.uim.oop.assignment3.author;


import java.util.List;

public interface IAuthorService {
    List<Author> getAll();
    Author create(AuthorRequest request);
    Author getAuthorById(Long id);
    Author updateAuthorById(Long authorId, AuthorRequest request);
    void deleteAuthorById(Long id);
}
