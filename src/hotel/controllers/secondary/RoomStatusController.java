package hotel.controllers.secondary;

import hotel.main.Rooms;
import hotel.queries.RoomStatusQueries;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class RoomStatusController implements Initializable{

    public static ObservableList<Rooms> data = FXCollections.observableArrayList();

    @FXML private TableView<Rooms> statusTable = new TableView<>();
    @FXML private TableColumn<Rooms, String> roomNumber = new TableColumn<>();
    @FXML private TableColumn<Rooms, String> roomCategory = new TableColumn<>();
    @FXML private TableColumn<Rooms, String> roomType = new TableColumn<>();
    @FXML private TableColumn<Rooms, String> roomLocation = new TableColumn<>();
    @FXML private TableColumn<Rooms, String> roomStatus = new TableColumn<>();

    public void reset() {

        for ( int i = 0; i < statusTable.getItems().size(); i++) {
            statusTable.getItems().clear();
        }

        data.clear();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        try {
            new RoomStatusQueries().loadTable();
        } catch (Exception e) {
            e.printStackTrace();
        }

        roomNumber.setCellValueFactory(new PropertyValueFactory<>("Number"));
        roomCategory.setCellValueFactory(new PropertyValueFactory<>("Category"));
        roomType.setCellValueFactory(new PropertyValueFactory<>("Type"));
        roomLocation.setCellValueFactory(new PropertyValueFactory<>("Location"));
        roomStatus.setCellValueFactory(new PropertyValueFactory<>("Status"));

        statusTable.setItems(data);
    }
}
