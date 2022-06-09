package sk.stuba.fei.uim.oop.assignment3.author;

import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface IAuthorRepository extends JpaRepository<Author, Long> {
    List<Author> findAll();
}
