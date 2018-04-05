package hotel.controllers.primary;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import hotel.main.Main;
import hotel.queries.LoginQuery;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.util.Objects;

// Controller class used for LoginGUI.fxml
public class LoginController extends Main {

    public static String Clearance;

    @FXML
    public Text errorText = new Text();

    @FXML
    public JFXButton btnSignIn = new JFXButton();

    @FXML
    public JFXTextField Username = new JFXTextField();

    @FXML
    public JFXPasswordField Password = new JFXPasswordField();

    // Method handles login functions and exceptions
    public void handleButtonAction(ActionEvent event) throws Exception {

        if (event.getTarget() == btnSignIn) {

            Username.setUnFocusColor(Color.valueOf("#333333"));
            Password.setUnFocusColor(Color.valueOf("#333333"));

            LoginQuery Db = new LoginQuery();
            Db.loginQuery(Username.getText(), Password.getText());

            Main main = new Main();

            if (Username.getText().equals("")) {
                errorText.setText("Missing required field.");
                errorText.setVisible(true);
                Username.setUnFocusColor(Color.valueOf("#E0202F"));
            }

            if (Password.getText().equals("")) {
                errorText.setText("Missing required field.");
                errorText.setVisible(true);
                Password.setUnFocusColor(Color.valueOf("#E0202F"));
            }

            if (Objects.equals(Clearance, "Admin")) {
                reset();
                main.adminGUI();
            }

            else if (Objects.equals(Clearance, "Receptionist")) {
                reset();
                main.receptionistGUI();
            }

            else if (Objects.equals(Clearance, "Housekeeper")) {
                reset();
                main.housekeeperGUI();
            }

            else if (Clearance == null && !Username.getText().equals("") && !Password.getText().equals("")) {
                errorText.setText("Incorrect username or password.");
                errorText.setVisible(true);
            }
        }
    }

    // Method resets all login related values
    private void reset() {

        Username.requestFocus();
        Username.setText("");
        Password.setText("");
        Clearance = null;
        errorText.setVisible(false);
    }
}