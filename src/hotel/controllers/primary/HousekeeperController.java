package hotel.controllers.primary;

import hotel.main.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.event.ActionEvent;

// Primary controller class used for handling action events
public class HousekeeperController extends Main {

    @FXML
    private Button btnDashboard, btnGuests, btnCalendar, btnHotelMap, btnRoomStatus, btnLogout;

    @FXML
    private AnchorPane dashboardPane, guestsPane, calendarPane, hotelmapPane, roomstatusPane;

    // Method handles pane switching on button presses
    @SuppressWarnings("Duplicates") @FXML
    public void handleButtonAction(ActionEvent event) {

        if (event.getTarget() == btnDashboard) {
            setVisibility();
            dashboardPane.setVisible(true);
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
        else if (event.getTarget() == btnRoomStatus) {
            setVisibility();
            roomstatusPane.setVisible(true);
        }
        else if (event.getTarget() == btnLogout) {
            currentStage.hide();
            loginStage.show();
        }
    }

    // Method hides all panes
    private void setVisibility() {

        dashboardPane.setVisible(false);
        guestsPane.setVisible(false);
        calendarPane.setVisible(false);
        hotelmapPane.setVisible(false);
        roomstatusPane.setVisible(false);
    }
}
