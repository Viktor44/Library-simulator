package sk.stuba.fei.uim.oop.assignment3.book;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService service;

    @GetMapping()
    public List<BookResponse> getAllBooks() {
        return this.service.getAll().stream().map(BookResponse::new).collect(Collectors.toList());
    }

    @PostMapping()
    public ResponseEntity<BookResponse> addBook(@RequestBody BookRequest request){
        return new ResponseEntity<>(new BookResponse(this.service.create(request)), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable("id") Long id) {
        return this.service.getBookById(id);
    }

    @PutMapping("/{id}")
    public Book updateAuthorById(@PathVariable("id") Long authorId, @RequestBody BookRequest request) {
        return this.service.updateBookById(authorId,request);
    }


    @DeleteMapping("/{id}")
    public void deleteBookById(@PathVariable("id") Long bookId){
         this.service.deleteBookById(bookId);
    }

    @GetMapping("/{id}/amount")
    public BookAmount getBookAmountById(@PathVariable("id") Long bookId){
        return this.service.getBookAmountById(bookId);
    }

    @PostMapping("/{id}/amount")
    public BookAmount updateBookAmountById(@PathVariable("id") Long bookId, @RequestBody BookAmount amount){
        return this.service.updateBookAmountById(bookId,amount);
    }

    @GetMapping("/{id}/lendCount")
    public BookAmount getBookLendCountById(@PathVariable("id") Long bookId){
        return this.service.getBookLendCountById(bookId);
    }
}
