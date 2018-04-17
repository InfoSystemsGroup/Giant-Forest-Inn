package hotel.controllers.primary;

import hotel.controllers.secondary.BookingController;
import hotel.controllers.secondary.DashboardController;
import hotel.controllers.secondary.RoomStatusController;
import hotel.main.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.event.ActionEvent;

// Primary controller class used for handling action events
public class ReceptionistController extends Main {

    @FXML
    private Button btnDashboard, btnBooking, btnGuests, btnCalendar, btnHotelMap, btnBilling, btnRoomStatus, btnLogout;

    @FXML
    private AnchorPane dashboardPane, bookingPane, guestsPane, calendarPane, hotelmapPane, billingPane, roomstatusPane;

    private DashboardController dc = new DashboardController();
    private BookingController bc = new BookingController();
    private RoomStatusController sc = new RoomStatusController();

    // Method handles pane switching on button presses
    @SuppressWarnings("Duplicates") @FXML
    public void handleButtonAction(ActionEvent event) {

        if (event.getTarget() == btnDashboard) {
            setVisibility();
            dashboardPane.setVisible(true);
        }
        else if (event.getTarget() == btnBooking) {
            setVisibility();
            bookingPane.setVisible(true);
        }
        else if (event.getTarget() == btnGuests) {
            setVisibility();
            guestsPane.setVisible(true);
        }
        else if (event.getTarget() == btnCalendar) {
            setVisibility();
            calendarPane.setVisible(true);
        }
        else if (event.getTarget() == btnHotelMap) {
            setVisibility();
            hotelmapPane.setVisible(true);
        }
        else if (event.getTarget() == btnBilling) {
            setVisibility();
            billingPane.setVisible(true);
        }
        else if (event.getTarget() == btnRoomStatus) {
            setVisibility();
            roomstatusPane.setVisible(true);
        }
        else if (event.getTarget() == btnLogout) {
            reset();
            currentStage.hide();
            loginStage.show();
        }
    }

    private void reset() {

        dc.reset();
        bc.reset();
        sc.reset();
    }

    // Method hides all panes
    private void setVisibility() {

        dashboardPane.setVisible(false);
        bookingPane.setVisible(false);
        guestsPane.setVisible(false);
        calendarPane.setVisible(false);
        hotelmapPane.setVisible(false);
        billingPane.setVisible(false);
        roomstatusPane.setVisible(false);
    }
}