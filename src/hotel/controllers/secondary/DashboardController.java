package hotel.controllers.secondary;

import hotel.main.Bookings;
import hotel.queries.DashboardQueries;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;

import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class DashboardController implements Initializable {

    protected static ObservableList<Bookings> bookings = FXCollections.observableArrayList();
    protected static ObservableList<PieChart.Data> rooms = FXCollections.observableArrayList();

    protected static ArrayList<String> status = new ArrayList<>();
    protected static ArrayList<Integer> amount = new ArrayList<>();
    protected static ArrayList<Integer> clean = new ArrayList<>();
    protected static ArrayList<Integer> dirty = new ArrayList<>();
    protected static ArrayList<Integer> needsRepair = new ArrayList<>();
    protected static ArrayList<Date> checkInDate = new ArrayList<>();
    protected static ArrayList<Date> checkOutDate = new ArrayList<>();
    protected static ArrayList<Integer> available = new ArrayList<>();
    protected static ArrayList<Integer> totalAvailable = new ArrayList<>();
    protected static ArrayList<Integer> totalGuests = new ArrayList<>();


    @FXML private Text availableRoomsField = new Text();
    @FXML private Text totalGuestsField = new Text();
    @FXML private Text totalBookingsField = new Text();
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

    void initialized() throws Exception {

        bookings.clear();
        latestBookingsTable.getItems().clear();
        available.clear();
        totalAvailable.clear();
        availableRoomsField.setText(null);
        totalGuestsField.setText(null);
        totalBookingsField.setText(null);
        checkInDate.clear();
        checkOutDate.clear();
        totalGuests.clear();

        try {
            new DashboardQueries().loadTable();
        } catch (Exception e) {
            e.printStackTrace();
        }

        roomNumber.setCellValueFactory(new PropertyValueFactory<>("Number"));
        firstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        checkIn.setCellValueFactory(new PropertyValueFactory<>("checkIn"));
        checkOut.setCellValueFactory(new PropertyValueFactory<>("checkOut"));

        try {
            availableRoomsField.setText(String.valueOf(new DashboardQueries().getAvailableRooms()));
            totalGuestsField.setText(String.valueOf(new DashboardQueries().getGuests()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        totalBookingsField.setText(String.valueOf(checkInDate.size()));

        latestBookingsTable.setItems(bookings);
    }

    private void initializePieChart() {

        rooms.clear();
        roomStatusChart.getData().clear();

        try {
            new DashboardQueries().loadPieChart();
        } catch (Exception e) {
            e.printStackTrace();
        }

        roomStatusChart.setData(rooms);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        try {
            initialized();
        } catch (Exception e) {
            e.printStackTrace();
        }
        initializePieChart();
    }
}
