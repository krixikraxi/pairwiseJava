package at.krixikraxi.splitwise.views;

import at.krixikraxi.splitwise.business.SplitwiseService;
import at.krixikraxi.splitwise.entities.Bill;
import at.krixikraxi.splitwise.views.tables.BaseTablePresenter;
import at.krixikraxi.splitwise.views.tables.BaseTableView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.layout.HBox;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MainPresenter {

    private static final Logger log = LoggerFactory.getLogger(MainPresenter.class);

    @Autowired
    private SplitwiseService splitwiseService;

    @FXML
    private HBox tableHBox;

    private ObservableList<Bill> billObservableList;

    @SuppressWarnings("unused")
    public void initialize() {
        log.debug("Init Presenter...");

        billObservableList = FXCollections.observableArrayList();
        billObservableList.setAll(splitwiseService.getAllBills());

        // add the table
        BaseTableView baseTableView = new BaseTableView();
        @SuppressWarnings("unchecked")
        BaseTablePresenter<Bill> baseTablePresenter = (BaseTablePresenter<Bill>) baseTableView.getPresenter();
        baseTablePresenter.setItems(billObservableList);
        tableHBox.getChildren().add(baseTableView.getView());
    }

    @FXML
    private void createNewBill() {
        log.debug("create a new bill");
        Bill b = new Bill("Bill1", "Bill One", Bill.User.ALEX);
        splitwiseService.saveBill(b);
        billObservableList.add(b);
    }
}
