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
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class DashboardController implements Initializable {

    public static ObservableList<Bookings> bookings = FXCollections.observableArrayList();
    public static ObservableList<PieChart.Data> rooms = FXCollections.observableArrayList();

    protected static ArrayList<String> status = new ArrayList<>();
    protected static ArrayList<Integer> amount = new ArrayList<>();
    protected static ArrayList<Integer> clean = new ArrayList<>();
    protected static ArrayList<Integer> dirty = new ArrayList<>();

    @FXML private Text availableRoomsField;
    @FXML private TableView<Bookings> latestBookingsTable = new TableView<>();
    @FXML private TableColumn<Bookings, String> firstName = new TableColumn<>();
    @FXML private TableColumn<Bookings, String> lastName = new TableColumn<>();
    @FXML private TableColumn<Bookings, String> roomNumber = new TableColumn<>();
    @FXML private TableColumn<Bookings, String> checkIn = new TableColumn<>();
    @FXML private TableColumn<Bookings, String> checkOut = new TableColumn<>();
    @FXML private PieChart roomStatusChart = new PieChart();

    public void reset() {

        for (int i = 0; i < latestBookingsTable.getItems().size(); i++) {
            latestBookingsTable.getItems().clear();
        }

        for (int i = 0; i < roomStatusChart.getData().size(); i++) {
            roomStatusChart.getData().clear();
        }

        bookings.clear();
        rooms.clear();
        status.clear();
        amount.clear();
        clean.clear();
        dirty.clear();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        //availableRoomsField =

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
