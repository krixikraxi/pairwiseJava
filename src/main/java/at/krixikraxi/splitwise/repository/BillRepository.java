package at.krixikraxi.splitwise.repository;

import at.krixikraxi.splitwise.entities.Bill;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BillRepository extends CrudRepository<Bill, Long> {

    Bill findById(Long Id);
    List<Bill> findAll();

}
