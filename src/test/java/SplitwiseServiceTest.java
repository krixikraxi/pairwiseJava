import at.krixikraxi.splitwise.SplitwiseApplication;
import at.krixikraxi.splitwise.business.SplitwiseService;
import at.krixikraxi.splitwise.entities.Bill;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SplitwiseApplication.class)
public class SplitwiseServiceTest {

    private static final Logger log = LoggerFactory.getLogger(SplitwiseServiceTest.class);

    @Autowired
    private SplitwiseService splitwiseService;

    @Before
    public void setUp() throws Exception {
        Bill bill1 = new Bill("Bill1", "Bill One", 13.50, Bill.User.ALEX, Bill.User.MANU);
        Bill bill2 = new Bill("Bill2", "Bill Two", 17.20, Bill.User.MANU, Bill.User.MANU);

        splitwiseService.saveBill(bill1);
        splitwiseService.saveBill(bill2);
    }

    @After
    public void tearDown() throws Exception {
        splitwiseService.removeAllBills();
    }

    @Test
    public void safeBillToRepositoryTest() throws Exception {
        Bill bill = new Bill("Billa", "Shopping Billa today", 12.30,  Bill.User.ALEX, Bill.User.MANU);
        Bill b = splitwiseService.saveBill(bill);

        assertNotNull(b.getId());
        assertTrue(b.getId() > 0);

        Bill savedBill = splitwiseService.getBillById(b.getId());

        assertNotNull(savedBill);
        assertEquals("Billa", savedBill.getBillName());
        assertEquals("Shopping Billa today", savedBill.getBillDescription());
        assertEquals(Bill.User.ALEX, savedBill.getFromUser());
    }

    @Test
    public void getBillsTest() throws Exception {
        List<Bill> billList = splitwiseService.getAllBills();

        assertNotNull(billList);
        assertTrue(billList.size() > 0);

        assertEquals("Bill1", billList.get(0).getBillName());
        assertEquals("Bill One", billList.get(0).getBillDescription());
        assertEquals(Bill.User.ALEX, billList.get(0).getFromUser());
    }
}
