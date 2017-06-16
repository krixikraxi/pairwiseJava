package at.krixikraxi.splitwise.views;

import at.krixikraxi.splitwise.business.SplitwiseService;
import javafx.fxml.FXML;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

@Component
public class MainPresenter {

    private static final Logger log = LoggerFactory.getLogger(MainPresenter.class);

    @Inject
    private SplitwiseService splitwiseService;

    public void initialize() {
        log.debug("Init Presenter...");
    }

    @FXML
    private void createNewBill() {
        System.out.println(splitwiseService.helloWorld());
    }
}
