package sk.stuba.fei.uim.oop.assignment3.list;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.stuba.fei.uim.oop.assignment3.book.*;


import java.util.List;


@Service
public class ListsService implements IListsService{

    private IListsRepository repository;


    @Autowired
    private IBookService bookService;

    ListsService(IListsRepository repository){
        this.repository = repository;
    }

    @Override
    public List<Lists> getAll() {
        return this.repository.findAll();
    }

    @Override
    public Lists create() {
        Lists l = new Lists();
        return this.repository.save(l);
    }

    @Override
    public Lists getListById(Long id) {
        this.repository.findById(id).orElseThrow();
        return this.repository.getOne(id);
    }

    @Override
    public void deleteListById(Long id) {
        this.repository.findById(id).orElseThrow();
        this.repository.deleteById(id);

    }

    @Override
    public Lists addBookToList(Long id, BookIdRequest request) {
        this.repository.findById(id).orElseThrow();
        Book b = this.bookService.getBookById(request.getId());
        Lists l = this.repository.getOne(id);
        l.getLendingList().add(b);
        this.repository.save(l);
        return l;
    }

    @Override
    public void lendLendingListById(Long id) {
        this.repository.findById(id).orElseThrow();
        for (int i=0;i<this.repository.getOne(id).getLendingList().size();i++){
            this.repository.getOne(id).getLendingList().get(i).setLendCount(this.repository.getOne(id).getLendingList().get(i).getLendCount()+1);
        }

    }

    @Override
    public void removeBookFromListById(Long id, BookIdRequest request) {
        this.repository.findById(id).orElseThrow();
       for(int i = 0;i<this.repository.getOne(id).getLendingList().size();i++){
            if (this.repository.getOne(id).getLendingList().get(i).getId().equals(request.getId())){
                this.repository.getOne(id).getLendingList().get(i).setLendCount(this.repository.getOne(id).getLendingList().get(i).getLendCount()-1);
                this.repository.getOne(id).setLended(false);
            }
        }

        this.repository.getOne(id).getLendingList().clear();
        this.repository.save(this.repository.getOne(id));
    }


}