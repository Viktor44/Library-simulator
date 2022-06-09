package sk.stuba.fei.uim.oop.assignment3.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.stuba.fei.uim.oop.assignment3.author.IAuthorRepository;
import sk.stuba.fei.uim.oop.assignment3.author.IAuthorService;

import java.util.List;
import java.util.Optional;

@Service
public class BookService implements IBookService{

    private IBookRepository repository;
    @Autowired
    private IAuthorService authorService;

    @Autowired
    public BookService(IBookRepository repository, IAuthorRepository authorRepository) {
        this.repository = repository;
    }

    @Override
    public List<Book> getAll() {
        return this.repository.findAll();
    }

    @Override
    public Book create(BookRequest request) {
        Book a = new Book();
        a.setName(request.getName());
        a.setDescription(request.getDescription());
        a.setPages(request.getPages());
        a.setAmount(request.getAmount());
        a.setLendCount(request.getLendCount());
        a.setAuthor(request.getAuthor());
        this.repository.save(a);
        this.authorService.getAuthorById(a.getAuthor()).getBooks().add(a.getId());
        return a;
    }

    @Override
    public Book getBookById(Long id) {
        this.repository.findById(id).orElseThrow();
        return this.repository.getOne(id);
    }

    @Override
    public Book addBookToAuthor(Long bookId, Long authorId) {
        Optional<Book> bookOpt = this.repository.findById(bookId);
        Book book = bookOpt.get();
        return this.repository.save(book);
    }

    @Override
    public Book updateBookById(Long bookId, BookRequest request) {
        this.repository.findById(bookId).orElseThrow();

        if (request.getDescription() != null)
            this.repository.getOne(bookId).setDescription(request.getDescription());
        if (request.getName() != null)
            this.repository.getOne(bookId).setName(request.getName());
        if (request.getAmount() != 0)
            this.repository.getOne(bookId).setAmount(request.getAmount());
        if (request.getPages() != 0)
            this.repository.getOne(bookId).setPages(request.getPages());
        if (request.getAuthor() != 0)
            this.repository.getOne(bookId).setAuthor(request.getAuthor());
        if (request.getLendCount() != 0)
            this.repository.getOne(bookId).setLendCount(request.getLendCount());
        return this.repository.save(this.repository.getOne(bookId));
    }

    @Override
    public void deleteBookById(Long bookId) {
        this.repository.findById(bookId).orElseThrow();
        for (int i = 0;i<this.authorService.getAuthorById(this.repository.getOne(bookId).getAuthor()).getBooks().size();i++){
            if (this.authorService.getAuthorById(this.repository.getOne(bookId).getAuthor()).getBooks().get(i) == this.repository.getOne(bookId).getId()){
                this.authorService.getAuthorById(this.repository.getOne(bookId).getAuthor()).getBooks().remove(i);
            }
        }
        this.repository.deleteById(bookId);

    }

    @Override
    public BookAmount getBookAmountById(Long bookId) {
        this.repository.findById(bookId).orElseThrow();
        BookAmount bA = new BookAmount();
        bA.setAmount(this.repository.getOne(bookId).getAmount());
        return bA;
    }

    @Override
    public BookAmount updateBookAmountById(Long bookId, BookAmount amount) {
        this.repository.findById(bookId).orElseThrow();
        int x = this.repository.getOne(bookId).getAmount() + amount.getAmount();
        Book b = this.repository.getOne(bookId);
        BookAmount bA = new BookAmount();
        b.setAmount(x);
        bA.setAmount(x);
        this.repository.save(b);
        return bA;
    }

    @Override
    public BookAmount getBookLendCountById(Long bookId){
        this.repository.findById(bookId).orElseThrow();
        BookAmount bA = new BookAmount();
        bA.setAmount(this.repository.getOne(bookId).getLendCount());
        return bA;
    }


}
