package at.krixikraxi.splitwise.views.tables;


import at.krixikraxi.splitwise.entities.Bill;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class BaseTablePresenter<C> {

    @FXML
    private TableView tableView;

    @FXML
    private TableColumn<C, Long> billIdColumn;

    @FXML
    private TableColumn<C, String> billDescriptionColumn;

    @FXML
    private TableColumn<C, Double> billAmountColumn;

    @FXML
    private TableColumn<C, Bill.User> billFromColumn;

    @FXML
    private TableColumn<C, Bill.User> billToColumn;

    @FXML
    private TableColumn<C, LocalDateTime> billDateTimeColumn;

    public BaseTablePresenter() {
    }

    public void initialize() {
        billIdColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        billDescriptionColumn.setCellValueFactory(new PropertyValueFactory<>("billDescription"));
        billAmountColumn.setCellValueFactory(new PropertyValueFactory<>("billAmount"));
        billFromColumn.setCellValueFactory(new PropertyValueFactory<>("fromUser"));
        billToColumn.setCellValueFactory(new PropertyValueFactory<>("toUser"));
        billDateTimeColumn.setCellValueFactory(new PropertyValueFactory<>("billDateTime"));

        billIdColumn.prefWidthProperty().bind(tableView.widthProperty().multiply(0.05));
        billDescriptionColumn.prefWidthProperty().bind(tableView.widthProperty().multiply(0.35));
        billAmountColumn.prefWidthProperty().bind(tableView.widthProperty().multiply(0.15));
        billFromColumn.prefWidthProperty().bind(tableView.widthProperty().multiply(0.10));
        billToColumn.prefWidthProperty().bind(tableView.widthProperty().multiply(0.10));
        billDateTimeColumn.prefWidthProperty().bind(tableView.widthProperty().multiply(0.24));
    }

    public void setItems(ObservableList<Bill> items) {
        tableView.setItems(items);
    }






}
