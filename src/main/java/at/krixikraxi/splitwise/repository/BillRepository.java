package at.krixikraxi.splitwise.repository;

import at.krixikraxi.splitwise.entities.Bill;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BillRepository extends CrudRepository<Bill, Long> {

    Bill findById(Long Id);
    List<Bill> findAll();

}
