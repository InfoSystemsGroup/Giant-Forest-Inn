package hotel.controllers.secondary;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import hotel.main.Billing;
import hotel.queries.BillingQueries;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.concurrent.CountDownLatch;

public class BillingController implements Initializable {

    public static ObservableList<Billing> data = FXCollections.observableArrayList();

    protected static ArrayList<String> fName = new ArrayList<>();
    protected static ArrayList<String> lName = new ArrayList<>();
    protected static ArrayList<Integer> roomNumber = new ArrayList<>();
    protected static ArrayList<Long> totalCost = new ArrayList<>();
    protected static ArrayList<Integer> roomCost = new ArrayList<>();
    protected static ArrayList<Date> checkIn = new ArrayList<>();
    protected static ArrayList<Date> checkOut = new ArrayList<>();

    protected static int personID;

    @FXML private JFXButton btnBack;
    @FXML private Text nameField, totalField;
    @FXML public JFXTextArea billOutput;
    @FXML private Pane billPane;
    @FXML private TableView<Billing> billingTable = new TableView<>();
    @FXML private TableColumn<Billing, String> firstName = new TableColumn<>();
    @FXML private TableColumn<Billing, String> lastName = new TableColumn<>();
    @FXML private TableColumn<Billing, String> numberOfRooms = new TableColumn<>();
    @FXML private TableColumn<Billing, String> nightsStayed = new TableColumn<>();
    @FXML private TableColumn<Billing, String> billTotal = new TableColumn<>();

    @FXML
    public void handleButtonAction(ActionEvent event) {

        if (event.getTarget() == btnBack) {

            btnBack.setVisible(false);
            billingTable.setVisible(true);
            billPane.setVisible(false);
            billOutput.clear();
            fName.clear();
            lName.clear();
            roomNumber.clear();
            totalCost.clear();
            roomCost.clear();
            checkIn.clear();
            checkOut.clear();
        }
    }

    public void handleMouseClick(MouseEvent event) {

        if (event.getButton().equals(MouseButton.PRIMARY)) {
            if (!billingTable.getSelectionModel().isEmpty()) {

                btnBack.setVisible(true);
                billingTable.setVisible(false);
                billPane.setVisible(true);

                try {
                    new BillingQueries().getSelection(
                            billingTable.getSelectionModel().getSelectedItem().getFirstName(),
                            billingTable.getSelectionModel().getSelectedItem().getLastName(),
                            billingTable.getSelectionModel().getSelectedItem().getBillTotal()
                    );

                    new BillingQueries().generateBill();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                for (int i = 0; i < fName.size(); i++) {

                    double tax = .0825;
                    SimpleDateFormat date = new SimpleDateFormat("MM/dd/yyy");

                    billOutput.setFocusTraversable(true);
                    billOutput.isFocused();

                    nameField.setText(fName.get(i) + " " + lName.get(i));
                    billOutput.appendText("\n\n" + date.format(checkIn.get(i)));
                    billOutput.appendText(String.valueOf("\t\tRoom (#" + roomNumber.get(i) + ")"));
                    billOutput.appendText(String.valueOf("\t\t\t\t\t$" + roomCost.get(i) + ".00"));
                    billOutput.appendText("\n\t\t\t\tRoom Tax");
                    billOutput.appendText("\t\t\t\t\t  $" + String.valueOf(String.format("%.2f", roomCost.get(i) * tax)));
                    if (i < fName.size() - 1)
                        billOutput.appendText("\n---------------------------------------------------------------------");
                    totalField.setText("Total $" + String.valueOf(String.format("%.2f", (totalCost.get(i) * tax) + totalCost.get(i))));
                }
            }
        }
    }

    public void initialized() {

        data.clear();
        billingTable.getItems().clear();

        try {
            new BillingQueries().loadTable();
        }

        catch (Exception e) {
            e.printStackTrace();
        }

        firstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        numberOfRooms.setCellValueFactory(new PropertyValueFactory<>("numberOfRooms"));
        nightsStayed.setCellValueFactory(new PropertyValueFactory<>("nightsStayed"));
        billTotal.setCellValueFactory(new PropertyValueFactory<>("billTotal"));

        billingTable.setItems(data);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        initialized();
    }
}