package sk.stuba.fei.uim.oop.assignment3.list;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface IListsRepository extends JpaRepository<Lists, Long> {
    List<Lists> findAll();
}
