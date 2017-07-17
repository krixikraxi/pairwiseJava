package at.krixikraxi.splitwise.views;

import at.krixikraxi.splitwise.business.SplitwiseService;
import at.krixikraxi.splitwise.entities.Bill;
import at.krixikraxi.splitwise.views.billdetails.BillDetailsPresenter;
import at.krixikraxi.splitwise.views.billdetails.BillDetailsView;
import at.krixikraxi.splitwise.views.tables.BaseTablePresenter;
import at.krixikraxi.splitwise.views.tables.BaseTableView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
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
    private AnchorPane billTableAnchorPane;

    @FXML
    private AnchorPane billAddAnchorPane;

    private ObservableList<Bill> billObservableList;

    @SuppressWarnings("unused")
    public void initialize() {
        log.debug("Init Presenter...");

        billObservableList = FXCollections.observableArrayList();
        billObservableList.setAll(splitwiseService.getAllBills());

        // add the table view
        BaseTableView baseTableView = new BaseTableView();
        @SuppressWarnings("unchecked")
        BaseTablePresenter<Bill> baseTablePresenter = (BaseTablePresenter<Bill>) baseTableView.getPresenter();
        baseTablePresenter.setItems(billObservableList);
        billTableAnchorPane.getChildren().add(baseTableView.getView());
        AnchorPane.setBottomAnchor(baseTableView.getView(), 0.0);
        AnchorPane.setLeftAnchor(baseTableView.getView(), 0.0);
        AnchorPane.setRightAnchor(baseTableView.getView(), 0.0);
        AnchorPane.setTopAnchor(baseTableView.getView(), 0.0);


        // add the edit/add bill view
        BillDetailsView billDetailsView = new BillDetailsView();
        @SuppressWarnings("unchecked")
        BillDetailsPresenter billDetailsPresenter = (BillDetailsPresenter) billDetailsView.getPresenter();
        billAddAnchorPane.getChildren().add(billDetailsView.getView());

        //set the dependencies
        billDetailsPresenter.setBillObservableList(billObservableList);
    }
}
