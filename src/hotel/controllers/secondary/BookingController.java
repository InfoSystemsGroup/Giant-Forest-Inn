package hotel.controllers.secondary;

import hotel.main.Rooms;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

public class BookingController implements Initializable {

    @FXML
    private Button btnSearchCriteria, btnBack, btnNext;

    @FXML
    private Pane availabilityPane;

    @FXML
    private TableView<Rooms> bookingTable = new TableView<>();

    @FXML
    private TableColumn<Rooms, String> roomNumber = new TableColumn<>();

    @FXML
    private TableColumn<Rooms, String> roomCategory = new TableColumn<>();

    @FXML
    private TableColumn<Rooms, String> roomType = new TableColumn<>();

    @FXML
    private TableColumn<Rooms, String> roomLocation = new TableColumn<>();

    @FXML
    private TableColumn<Rooms, String> roomSleeps = new TableColumn<>();

    @FXML
    private TableColumn<Rooms, String> roomAvailability = new TableColumn<>();

    @FXML
    private TableColumn<Rooms, String> roomPrice = new TableColumn<>();

    @FXML
    private TableColumn<Rooms, String> roomSelect = new TableColumn<>();

    @FXML
    public void handleButtonAction(ActionEvent event) {

        if (event.getTarget() == btnSearchCriteria) {
            availabilityPane.setVisible(false);
            bookingTable.setVisible(true);
            btnBack.setVisible(true);
            btnNext.setVisible(true);
        }

        if (bookingTable.isVisible()) {

            if (event.getTarget() == btnBack) {
                btnBack.setVisible(false);
                btnNext.setVisible(false);
                bookingTable.setVisible(false);
                availabilityPane.setVisible(true);
            }
            else if (event.getTarget() == btnNext) {

            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        final ObservableList<Rooms> data = FXCollections.observableArrayList(
                new Rooms( "100","Luxury", "1 Queen Bed", "Forest", "2", "1", "$260.00"),
                new Rooms( "101","Luxury", "1 Queen Bed", "Forest", "2", "1", "$260.00"),
                new Rooms( "102","Luxury", "1 Queen Bed", "Forest", "2", "1", "$260.00"),
                new Rooms( "103","Luxury", "1 Queen Bed", "Forest", "2", "1", "$260.00"),
                new Rooms( "104","Luxury", "1 Queen Bed", "Forest", "2", "1", "$260.00")
        );

        roomNumber.setCellValueFactory(new PropertyValueFactory<>("Number"));
        roomCategory.setCellValueFactory(new PropertyValueFactory<>("Category"));
        roomType.setCellValueFactory(new PropertyValueFactory<>("Type"));
        roomLocation.setCellValueFactory(new PropertyValueFactory<>("Location"));
        roomSleeps.setCellValueFactory(new PropertyValueFactory<>("Sleeps"));
        roomAvailability.setCellValueFactory(new PropertyValueFactory<>("Available"));
        roomPrice.setCellValueFactory(new PropertyValueFactory<>("Price"));
        roomSelect.setCellValueFactory(new PropertyValueFactory<>("Select"));

        bookingTable.setItems(data);
    }
}