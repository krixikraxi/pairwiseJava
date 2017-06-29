package at.krixikraxi.splitwise.views;

import at.krixikraxi.splitwise.business.SplitwiseService;
import at.krixikraxi.splitwise.entities.Bill;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

@Component
public class MainPresenter {

    private static final Logger log = LoggerFactory.getLogger(MainPresenter.class);

    @Autowired
    private SplitwiseService splitwiseService;

    @FXML
    private TableView<Bill> billTableView;

    private ObservableList<Bill> billObservableList;

    @SuppressWarnings("unused")
    public void initialize() {
        log.debug("Init Presenter...");
        billTableView.setItems(billObservableList);

        billObservableList = FXCollections.observableArrayList();
        //billObservableList.setAll(splitwiseService.getAllBills());
    }

    @FXML
    private void createNewBill() {
        log.debug("create a new bill");
        Bill b = new Bill("Bill1", "Bill One", Bill.User.ALEX);
        splitwiseService.saveBill(b);
        billObservableList.add(b);
    }
}
