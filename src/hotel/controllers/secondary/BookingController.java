package hotel.controllers.secondary;

import hotel.main.Rooms;
import hotel.queries.BookingQueries;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

public class BookingController implements Initializable {

    @FXML
    public static ObservableList data = FXCollections.observableArrayList();

    @FXML
    private Button btnSearchCriteria, btnBack, btnNext;

    @FXML
    private Pane availabilityPane;

    @FXML
    private ComboBox<String> categoryBox, typeBox, locationBox;

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
    private TableColumn<Rooms, String> roomPrice = new TableColumn<>();

    @FXML
    private TableColumn<Rooms, String> roomSelect = new TableColumn<>();

    @FXML
    public void handleButtonAction(ActionEvent event) throws Exception {

        if (event.getTarget() == btnSearchCriteria) {
            availabilityPane.setVisible(false);
            bookingTable.setVisible(true);
            btnBack.setVisible(true);
            btnNext.setVisible(true);

            BookingQueries bq = new BookingQueries();
            bq.loadTable(categoryBox.getValue(), typeBox.getValue(), locationBox.getValue());
            populateTable();
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

            }
        }
    }

    public void reset() {

        for ( int i = 0; i < bookingTable.getItems().size(); i++) {
            bookingTable.getItems().clear();
        }
    }

    public void populateTable() {

        roomNumber.setCellValueFactory(new PropertyValueFactory<>("Number"));
        roomCategory.setCellValueFactory(new PropertyValueFactory<>("Category"));
        roomType.setCellValueFactory(new PropertyValueFactory<>("Type"));
        roomLocation.setCellValueFactory(new PropertyValueFactory<>("Location"));
        roomSleeps.setCellValueFactory(new PropertyValueFactory<>("Sleeps"));
        roomPrice.setCellValueFactory(new PropertyValueFactory<>("Price"));
        roomSelect.setCellValueFactory(new PropertyValueFactory<>("Select"));

        bookingTable.setItems(data);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        final ObservableList<String> anyType = FXCollections.observableArrayList("", "1 Queen", "2 Queens", "2 Room", "3 Room", "4 Room", "Bridal");
        final ObservableList<String> Luxury = FXCollections.observableArrayList("", "1 Queen", "2 Queens", "2 Room", "3 Room", "Bridal");
        final ObservableList<String> Cottage = FXCollections.observableArrayList("", "2 Room", "3 Room", "4 Room");
        final ObservableList<String> category = FXCollections.observableArrayList("", "Luxury", "Cottage");
        final ObservableList<String> location = FXCollections.observableArrayList("", "Patio", "Forest");

        categoryBox.setItems(category);
        typeBox.setItems(anyType);
        locationBox.setItems(location);

        categoryBox.getSelectionModel().selectedItemProperty().addListener((ChangeListener) (observable, oldValue, newValue) -> {

            switch (newValue.toString()) {
                case "Luxury":
                    typeBox.setItems(Luxury);
                    break;
                case "Cottage":
                    typeBox.setItems(Cottage);
            }
        });
    }
}