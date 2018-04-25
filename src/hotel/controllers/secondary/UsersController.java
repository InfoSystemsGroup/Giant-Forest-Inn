package hotel.controllers.secondary;

import hotel.main.Billing;
import hotel.main.Users;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

public class UsersController {

    @FXML private TableView<Users> usersTable = new TableView<>();
    @FXML private TableColumn<Users, String> firstName = new TableColumn<>();
    @FXML private TableColumn<Users, String> lastName = new TableColumn<>();
    @FXML private TableColumn<Users, String> clearanceLevel = new TableColumn<>();

    public void handleMouseClick(MouseEvent event) {

        if (event.getButton().equals(MouseButton.PRIMARY)) {
            if (!usersTable.getSelectionModel().isEmpty()) {


            }
        }
    }
}
