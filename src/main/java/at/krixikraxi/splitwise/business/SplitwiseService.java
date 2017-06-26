package at.krixikraxi.splitwise.business;

import at.krixikraxi.splitwise.entities.Bill;
import at.krixikraxi.splitwise.repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SplitwiseService {

    @Autowired
    private BillRepository billRepository;

    public String helloWorld() {
        return "hello world!";
    }

    public void saveBill(Bill bill) {
        billRepository.save(bill);
    }

    public List<Bill> getAllBills() {
        return billRepository.findAll();
    }
}
