package at.krixikraxi.splitwise.business;

import at.krixikraxi.splitwise.entities.Bill;
import at.krixikraxi.splitwise.repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class SplitwiseService {

    @Autowired
    private BillRepository billRepository;

    public Bill saveBill(Bill bill) {
        return billRepository.save(bill);
    }

    public Bill getBillById(Long id) {
        return billRepository.findById(id);
    }

    public List<Bill> getAllBills() {
        return billRepository.findAll();
    }

    public void removeAllBills() {
        billRepository.deleteAll();
    }
}
