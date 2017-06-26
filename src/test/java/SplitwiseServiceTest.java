import at.krixikraxi.splitwise.SplitwiseApplication;
import at.krixikraxi.splitwise.business.SplitwiseService;
import at.krixikraxi.splitwise.entities.Bill;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SplitwiseApplication.class)
public class SplitwiseServiceTest {

    private static final Logger log = LoggerFactory.getLogger(SplitwiseServiceTest.class);

    @Autowired
    private SplitwiseService splitwiseService;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void safeBillToRepositoryTest() throws Exception {
        Bill bill = new Bill("Billa", "Shopping Billa today", Bill.User.ALEX);
        splitwiseService.saveBill(bill);

        log.info(bill.toString());


    }
}
