package sk.stuba.fei.uim.oop.assignment3.list;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sk.stuba.fei.uim.oop.assignment3.book.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/list")
public class ListsController {

    @Autowired
    private ListsService service;

    @GetMapping()
    public List<ListsResponse> getAllBooks() {
        return this.service.getAll().stream().map(ListsResponse::new).collect(Collectors.toList());
    }

    @PostMapping()
    public ResponseEntity<ListsResponse> addList(){
        return new ResponseEntity<>(new ListsResponse(this.service.create()), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public Lists getListById(@PathVariable("id") Long id) {
        return this.service.getListById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteListById(@PathVariable("id") Long id){
         this.service.deleteListById(id);
    }

    @PostMapping("/{id}/add")
    public Lists addBookToList(@PathVariable("id") Long id,@RequestBody BookIdRequest request){
        return this.service.addBookToList(id,request);
    }

    @GetMapping("/{id}/lend")
    public void lendLendingListById(@PathVariable("id") Long id){
         this.service.lendLendingListById(id);
    }

    @DeleteMapping("/{id}/remove")
    public void removeBookFromListById(@PathVariable("id") Long id,@RequestBody BookIdRequest request){
        this.service.removeBookFromListById(id,request);
    }
}
