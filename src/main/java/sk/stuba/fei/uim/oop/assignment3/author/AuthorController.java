package sk.stuba.fei.uim.oop.assignment3.author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/author")
public class AuthorController {
    @Autowired
    private AuthorService service;


    @GetMapping()
    public List<AuthorResponse> getAllAuthors() {
        return this.service.getAll().stream().map(AuthorResponse::new).collect(Collectors.toList());
    }

    @PostMapping()
    public ResponseEntity<AuthorResponse> addAuthor(@RequestBody AuthorRequest request) {
        return new ResponseEntity<>(new AuthorResponse(this.service.create(request)), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public Author getAllAuthorsById(@PathVariable("id") Long id) {
        return this.service.getAuthorById(id);
    }

    @PutMapping("/{id}")
    public Author updateAuthorById(@PathVariable("id") Long authorId, @RequestBody AuthorRequest request) {
        return this.service.updateAuthorById(authorId,request);
    }

    @DeleteMapping("/{id}")
    public void deleteAuthorById(@PathVariable("id") Long authorId){
        this.service.deleteAuthorById(authorId);
    }



}
