package sk.stuba.fei.uim.oop.assignment3.author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.stuba.fei.uim.oop.assignment3.book.IBookService;

import java.util.List;


@Service
public class AuthorService implements IAuthorService {

    private IAuthorRepository repository;
    @Autowired
    private IBookService bookService;

    @Autowired
    public AuthorService(IAuthorRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Author> getAll() {
        return this.repository.findAll();
    }

    @Override
    public Author create(AuthorRequest request) {
        Author a = new Author();
        a.setName(request.getName());
        a.setSurname(request.getSurname());
        this.repository.save(a);
        return a;
    }

    @Override
    public Author getAuthorById(Long id) {
        this.repository.findById(id).orElseThrow();
        return this.repository.getOne(id);
    }

    @Override
    public Author updateAuthorById(Long authorId,AuthorRequest request) {
        this.repository.findById(authorId).orElseThrow();
        if (request.getSurname() != null)
            this.repository.getOne(authorId).setSurname(request.getSurname());
        if (request.getName() != null)
            this.repository.getOne(authorId).setName(request.getName());
        return this.repository.save(this.repository.getOne(authorId));
    }

    @Override
    public void deleteAuthorById(Long id) {
        this.repository.findById(id).orElseThrow();
        List<Long> l = this.repository.getOne(id).getBooks();
        for (int i = 0;i<this.repository.getOne(id).getBooks().size();i++){
            Long x = l.get(i);
            this.bookService.deleteBookById(l.get(i));
        }
        this.repository.deleteById(id);

    }
}
