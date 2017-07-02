package at.krixikraxi.splitwise.views.tables;


import at.krixikraxi.splitwise.entities.Bill;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.springframework.stereotype.Component;

@Component
public class BaseTablePresenter<C> {

    @FXML
    private TableView tableView;

    @FXML
    private TableColumn<C, Long> billIdColumn;

    @FXML
    private TableColumn<C, String> billNameColumn;

    @FXML
    private TableColumn<C, String> billDescriptionColumn;

    @FXML
    private TableColumn<C, Bill.User> billFromColumn;

    @FXML
    private TableColumn<C, Bill.User> billToColumn;

    public BaseTablePresenter() {
    }

    public void initialize() {
        billIdColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        billNameColumn.setCellValueFactory(new PropertyValueFactory<>("billName"));
        billDescriptionColumn.setCellValueFactory(new PropertyValueFactory<>("billDescription"));
        billFromColumn.setCellValueFactory(new PropertyValueFactory<>("fromUser"));
        billToColumn.setCellValueFactory(new PropertyValueFactory<>("toUser"));
    }

    public void setItems(ObservableList<Bill> items) {
        tableView.setItems(items);
    }






}
