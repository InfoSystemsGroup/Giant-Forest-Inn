package hotel.controllers.secondary;

import com.jfoenix.controls.JFXTextField;
import hotel.main.Rooms;
import hotel.queries.BookingQueries;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ResourceBundle;

public class BookingController implements Initializable {

    private LocalDate currentDate = LocalDate.now();

    public static ObservableList<Rooms> data = FXCollections.observableArrayList();

    public static String personID, bookingID, roomID, price, fName, lName;

    private static long days;

    @FXML private Pane availabilityPane, informationPane;
    @FXML private DatePicker checkInDate, checkOutDate;
    @FXML private Button btnSearchCriteria, btnMakeReservation, btnBack, btnNext;
    @FXML private JFXTextField txtFirstName, txtLastName, txtPhone, txtEmail, txtAddress, txtCity, txtState, txtZipcode;
    @FXML private ComboBox<String> categoryBox, typeBox, locationBox;
    @FXML private TableView<Rooms> bookingTable = new TableView<>();
    @FXML private TableColumn<Rooms, String> roomSelect = new TableColumn<>();
    @FXML private TableColumn<Rooms, String> roomNumber = new TableColumn<>();
    @FXML private TableColumn<Rooms, String> roomCategory = new TableColumn<>();
    @FXML private TableColumn<Rooms, String> roomType = new TableColumn<>();
    @FXML private TableColumn<Rooms, String> roomLocation = new TableColumn<>();
    @FXML private TableColumn<Rooms, String> roomSleeps = new TableColumn<>();
    @FXML private TableColumn<Rooms, String> roomPrice = new TableColumn<>();

    @FXML
    public void handleButtonAction(ActionEvent event) throws Exception {

        if (event.getTarget() == btnSearchCriteria) {

            if (checkInDate.getValue() == null || checkOutDate.getValue() == null)
                System.out.println("Need date!");

            else if (checkInDate.getValue().isBefore(currentDate) || checkOutDate.getValue().isBefore(currentDate))
                System.out.println("Invalid date!");

            else if (checkOutDate.getValue().isBefore(checkInDate.getValue()))
                System.out.println("Check out date cannot be before check in date!");

            else {
                availabilityPane.setVisible(false);
                bookingTable.setVisible(true);
                btnBack.setVisible(true);
                btnNext.setVisible(true);

                BookingQueries bq = new BookingQueries();
                bq.loadTable(checkInDate.getValue(), checkOutDate.getValue(), categoryBox.getValue(), typeBox.getValue(), locationBox.getValue());
                populateTable();
            }
        }

        if (bookingTable.isVisible()) {

            if (event.getTarget() == btnBack) {
                btnBack.setVisible(false);
                btnNext.setVisible(false);
                bookingTable.setVisible(false);
                availabilityPane.setVisible(true);

                reset();
            }
            else if (event.getTarget() == btnNext) {

                btnNext.setVisible(false);
                bookingTable.setVisible(false);
                informationPane.setVisible(true);
            }
        }

        else if (informationPane.isVisible()) {

            if (event.getTarget() == btnBack) {

                informationPane.setVisible(false);
                btnNext.setVisible(true);
                bookingTable.setVisible(true);
            }
        }

        if (event.getTarget() == btnMakeReservation) {

            BookingQueries bq = new BookingQueries();

            bq.userInformation(txtFirstName.getText(), txtLastName.getText(), txtPhone.getText(), txtEmail.getText(),
                    txtAddress.getText(), txtCity.getText(), txtState.getText(), txtZipcode.getText());

            for (Rooms bean : data)
                if (bean.getSelect().isSelected()) {
                    System.out.println(bean.getNumber());
                    bq.selectRooms(bean.getNumber(), personID, checkInDate.getValue(), checkOutDate.getValue());
            }
        }
    }

    public long calculateDays() {

        days = ChronoUnit.DAYS.between(checkInDate.getValue(), checkOutDate.getValue());

        return days;
    }

    public int calculateTotal(int cost) {

        return cost;
    }

    public void reset() {

        for ( int i = 0; i < bookingTable.getItems().size(); i++) {
            bookingTable.getItems().clear();
        }

        data.clear();
    }

    public void populateTable() {

        roomSelect.setCellValueFactory(new PropertyValueFactory<>("Select"));
        roomNumber.setCellValueFactory(new PropertyValueFactory<>("Number"));
        roomCategory.setCellValueFactory(new PropertyValueFactory<>("Category"));
        roomType.setCellValueFactory(new PropertyValueFactory<>("Type"));
        roomLocation.setCellValueFactory(new PropertyValueFactory<>("Location"));
        roomSleeps.setCellValueFactory(new PropertyValueFactory<>("Sleeps"));
        roomPrice.setCellValueFactory(new PropertyValueFactory<>("Price"));

        bookingTable.setItems(data);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        final ObservableList<String> anyType = FXCollections.observableArrayList("", "1 Queen Bed", "2 Queen Bed", "Two Room", "Three Room", "Four Room", "Bridal");
        final ObservableList<String> Luxury = FXCollections.observableArrayList("", "1 Queen Bed", "2 Queen Bed", "Two Room", "Three Room", "Bridal");
        final ObservableList<String> Cottage = FXCollections.observableArrayList("", "Two Room", "Three Room", "Four Room");
        final ObservableList<String> category = FXCollections.observableArrayList("", "Luxury", "Cottage");
        final ObservableList<String> location = FXCollections.observableArrayList("", "Patio", "Forest");

        categoryBox.setItems(category);
        typeBox.setItems(anyType);
        locationBox.setItems(location);

        categoryBox.getSelectionModel().selectedItemProperty().addListener((ChangeListener) (observable, oldValue, newValue) -> {

            switch (newValue.toString()) {
                case "":
                    typeBox.setItems(anyType);
                    break;
                case "Luxury":
                    typeBox.setItems(Luxury);
                    break;
                case "Cottage":
                    typeBox.setItems(Cottage);
                    break;
            }
        });
    }
}