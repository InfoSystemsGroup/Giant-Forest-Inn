package hotel;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.event.ActionEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private Button btnDashboard, btnBooking, btnGuests, btnCalendar, btnHotelMap, btnBilling;

    @FXML
    private AnchorPane dashboardPane, bookingPane, guestsPane, calendarPane, hotelmapPane, billingPane;

    @FXML
    public void handleButtonAction (ActionEvent event) {

        if (event.getTarget() == btnDashboard) {
            dashboardPane.setVisible(true);
            bookingPane.setVisible(false);
            guestsPane.setVisible(false);
            calendarPane.setVisible(false);
            hotelmapPane.setVisible(false);
            billingPane.setVisible(false);
        }

        else if (event.getSource() == btnBooking) {
            dashboardPane.setVisible(false);
            bookingPane.setVisible(true);
            guestsPane.setVisible(false);
            calendarPane.setVisible(false);
            hotelmapPane.setVisible(false);
            billingPane.setVisible(false);
        }

        else if (event.getSource() == btnGuests) {
            dashboardPane.setVisible(false);
            bookingPane.setVisible(false);
            guestsPane.setVisible(true);
            calendarPane.setVisible(false);
            hotelmapPane.setVisible(false);
            billingPane.setVisible(false);
        }

        else if (event.getSource() == btnCalendar) {
            dashboardPane.setVisible(false);
            bookingPane.setVisible(false);
            guestsPane.setVisible(false);
            calendarPane.setVisible(true);
            hotelmapPane.setVisible(false);
            billingPane.setVisible(false);
        }

        else if (event.getSource() == btnHotelMap) {
            dashboardPane.setVisible(false);
            bookingPane.setVisible(false);
            guestsPane.setVisible(false);
            calendarPane.setVisible(false);
            hotelmapPane.setVisible(true);
            billingPane.setVisible(false);
        }

        else if (event.getSource() == btnBilling) {
            dashboardPane.setVisible(false);
            bookingPane.setVisible(false);
            guestsPane.setVisible(false);
            calendarPane.setVisible(false);
            hotelmapPane.setVisible(false);
            billingPane.setVisible(true);
        }
    }

    public void initialize(URL url, ResourceBundle rb) {

    }
}