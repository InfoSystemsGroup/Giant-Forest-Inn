package controllers;


import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import hotel.Main;
import hotel.Queries;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

// Controller class used for LoginGUI.fxml
public class LoginController extends Main implements Initializable {

    public static String Clearance;

    @FXML
    public Text errorText = new Text();

    @FXML
    public JFXButton btnSignIn = new JFXButton();

    @FXML
    public JFXTextField Username = new JFXTextField();

    @FXML
    public JFXPasswordField Password = new JFXPasswordField();

    public void handleButtonAction(ActionEvent event) throws Exception {

        if (event.getTarget() == btnSignIn) {

            Username.setUnFocusColor(Color.valueOf("#333333"));
            Password.setUnFocusColor(Color.valueOf("#333333"));

            Queries Db = new Queries();
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
                main.adminPanel();
            }

            else if (Objects.equals(Clearance, "Receptionist")) {
                reset();
                main.receptionistPanel();
            }

            else if (Objects.equals(Clearance, "Housekeeper")) {
                reset();
                main.housekeeperPanel();
            }

            else if (Clearance == null && !Username.getText().equals("") && !Password.getText().equals("")) {
                errorText.setText("Incorrect username or password.");
                errorText.setVisible(true);
            }
        }
    }

    private void reset() {

        Username.requestFocus();
        Username.setText("");
        Password.setText("");
        Clearance = null;
        errorText.setVisible(false);
    }

    public void initialize(URL url, ResourceBundle rb) {

    }
}
