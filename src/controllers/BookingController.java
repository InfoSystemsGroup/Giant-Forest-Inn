package controllers;

import hotel.Rooms;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class BookingController implements Initializable {

    @FXML
    private TableView<Rooms> bookingTable = new TableView<>();

    @FXML
    private TableColumn<Rooms, String> roomCategory = new TableColumn<>();

    @FXML
    private TableColumn<Rooms, String> roomType = new TableColumn<>();

    @FXML
    private TableColumn<Rooms, String> roomLocation = new TableColumn<>();

    @FXML
    private TableColumn<Rooms, String> roomSleeps = new TableColumn<>();

    @FXML
    private TableColumn<Rooms, String> roomAvailable = new TableColumn<>();

    @FXML
    private TableColumn<Rooms, String> roomPrice = new TableColumn<>();

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        final ObservableList<Rooms> data = FXCollections.observableArrayList(
            new Rooms("Luxury", "1 Queen Bed", "Forest", "2", "1", "$260.00"),
            new Rooms("Cottage", "2 Queen Bed", "Patio", "4", "3", "$290.00")
        );

        roomCategory.setCellValueFactory(new PropertyValueFactory<>("Category"));
        roomType.setCellValueFactory(new PropertyValueFactory<>("Type"));
        roomLocation.setCellValueFactory(new PropertyValueFactory<>("Location"));
        roomSleeps.setCellValueFactory(new PropertyValueFactory<>("Sleeps"));
        roomAvailable.setCellValueFactory(new PropertyValueFactory<>("Available"));
        roomPrice.setCellValueFactory(new PropertyValueFactory<>("Price"));

        bookingTable.setItems(data);
    }
}