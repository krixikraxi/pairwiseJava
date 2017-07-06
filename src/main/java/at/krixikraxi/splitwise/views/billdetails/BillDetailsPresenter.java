package at.krixikraxi.splitwise.views.billdetails;


import at.krixikraxi.splitwise.business.SplitwiseService;
import at.krixikraxi.splitwise.entities.Bill;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BillDetailsPresenter {

    @Autowired
    private SplitwiseService splitwiseService;

    @FXML
    private TextField billDescriptionTextField;

    @FXML
    private TextField billAmountTextField;

    @FXML
    private ChoiceBox<Bill.User> billFromChoiceBox;

    @FXML
    private ChoiceBox<Bill.User> billToChoiceBox;

    private static final Logger log = LoggerFactory.getLogger(BillDetailsPresenter.class);
    private ObservableList<Bill> billObservableList;

    public BillDetailsPresenter() {
    }

    public void initialize() {
        billFromChoiceBox.setItems(FXCollections.observableArrayList(Bill.User.values()));
        billFromChoiceBox.getSelectionModel().selectLast();
        billToChoiceBox.setItems(FXCollections.observableArrayList(Bill.User.values()));
        billToChoiceBox.getSelectionModel().selectLast();

        billAmountTextField.focusedProperty().addListener((arg0, oldValue, newValue) -> {
            if (!newValue) { //when focus lost
                billAmountTextField.setText(billAmountTextField.getText().replace(',', '.'));
                if(!billAmountTextField.getText().matches("[0-9]+(\\.[0-9][0-9]?)?")){
                    billAmountTextField.setText("");
                }
            }
        });
    }

    @FXML
    private void saveNewBill() {
        if(validateInput()) {
            log.debug("create a new bill");
            Bill newBill = new Bill(billDescriptionTextField.getText(), Double.parseDouble(billAmountTextField.getText()), billFromChoiceBox.getValue(), billToChoiceBox.getValue());
            Bill savedBill = splitwiseService.saveBill(newBill);
            billObservableList.add(savedBill);
        }
    }

    private boolean validateInput() {
        if(billFromChoiceBox.getSelectionModel().getSelectedItem() == billToChoiceBox.getSelectionModel().getSelectedItem()) {
            log.debug("validate error: same from and to user");
            return false;
        } else if(billFromChoiceBox.getValue() == Bill.User.EMPTY && billToChoiceBox.getValue() == Bill.User.EMPTY) {
            log.debug("validate error: from and to user empty");
            return false;
        } else if(billDescriptionTextField.getText().isEmpty() || billAmountTextField.getText().isEmpty()) {
            log.debug("validate error: bill description or amount is empty");
            return false;
        }
        log.debug("validation ok");
        return true;
    }

    public void setBillObservableList(ObservableList<Bill> billObservableList) {
        if(this.billObservableList == null) {
            this.billObservableList = billObservableList;
        }
    }
}
