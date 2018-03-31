package controllers;

import hotel.Main;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.event.ActionEvent;

import java.net.URL;
import java.util.ResourceBundle;

// Primary controller class used for handling action events
public class MainController extends Main implements Initializable {

    //@FXML
    //private BookingController bookingController;

    @FXML
    private Button btnDashboard, btnBooking, btnGuests, btnCalendar, btnHotelMap, btnBilling, btnLogout;

    @FXML
    private AnchorPane dashboardPane, bookingPane, guestsPane, calendarPane, hotelmapPane, billingPane;

    // Method handles pane switching on button presses
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

        else if (event.getTarget() == btnLogout) {
            currentStage.hide();
            loginStage.show();
        }
    }

    // Method hides all panes
    private void setVisibility() {

        dashboardPane.setVisible(false);
        bookingPane.setVisible(false);
        guestsPane.setVisible(false);
        calendarPane.setVisible(false);
        hotelmapPane.setVisible(false);
        billingPane.setVisible(false);
    }

    public void initialize(URL url, ResourceBundle rb) {

        //bookingController.injectMainController(this);
    }
}