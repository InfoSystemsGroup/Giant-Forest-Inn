package hotel.controllers.secondary;

import hotel.main.Bookings;
import hotel.main.Rooms;
import hotel.queries.DashboardQueries;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.PieChartBuilder;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class DashboardController implements Initializable {

    public static ObservableList<Bookings> bookings = FXCollections.observableArrayList();
    public static ObservableList<PieChart.Data> rooms = FXCollections.observableArrayList();


    @FXML private TableView<Bookings> latestBookingsTable = new TableView<>();
    @FXML private TableColumn<Bookings, String> firstName = new TableColumn<>();
    @FXML private TableColumn<Bookings, String> lastName = new TableColumn<>();
    @FXML private TableColumn<Bookings, String> roomNumber = new TableColumn<>();
    @FXML private TableColumn<Bookings, String> checkIn = new TableColumn<>();
    @FXML private TableColumn<Bookings, String> checkOut = new TableColumn<>();
    @FXML private PieChart roomStatusChart;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        try {
            new DashboardQueries().loadTable();
            new DashboardQueries().loadPieChart();
        } catch (Exception e) {
            e.printStackTrace();
        }

        roomNumber.setCellValueFactory(new PropertyValueFactory<>("Number"));
        firstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        checkIn.setCellValueFactory(new PropertyValueFactory<>("checkIn"));
        checkOut.setCellValueFactory(new PropertyValueFactory<>("checkOut"));

        latestBookingsTable.setItems(bookings);

        roomStatusChart.setData(rooms);
    }
}
