package controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.event.ActionEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    private Button btnDashboard, btnBooking, btnGuests, btnCalendar, btnHotelMap, btnBilling;

    @FXML
    private AnchorPane dashboardPane, bookingPane, guestsPane, calendarPane, hotelmapPane, billingPane;

    @FXML
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
    }

    public void setVisibility() {

        dashboardPane.setVisible(false);
        bookingPane.setVisible(false);
        guestsPane.setVisible(false);
        calendarPane.setVisible(false);
        hotelmapPane.setVisible(false);
        billingPane.setVisible(false);
    }

    public void initialize(URL url, ResourceBundle rb) {

    }
}