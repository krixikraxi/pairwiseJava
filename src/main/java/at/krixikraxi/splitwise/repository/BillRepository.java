package at.krixikraxi.splitwise.repository;

import at.krixikraxi.splitwise.entities.Bill;
import org.springframework.data.repository.CrudRepository;

public interface BillRepository extends CrudRepository<Bill, Long> {

    Bill findById(Long Id);

}
