package controllers;


import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import hotel.Main;
import hotel.Queries;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

// Controller class used for LoginGUI.fxml
public class LoginController extends Main implements Initializable {

    public static String Clearance;

    @FXML
    public JFXButton btnSignIn = new JFXButton();

    @FXML
    public Text errorText = new Text();

    @FXML
    public JFXTextField Username = new JFXTextField();

    @FXML
    public JFXPasswordField Password = new JFXPasswordField();


    public void handleButtonAction(ActionEvent event) throws Exception {

        if (event.getTarget() == btnSignIn) {

            Username.setUnFocusColor(Color.valueOf("#333333"));
            Password.setUnFocusColor(Color.valueOf("#333333"));

            Queries Db = new Queries();
            Db.LoginQuery(Username.getText(), Password.getText());

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
                main.AdminPanel();
            }

            else if (Objects.equals(Clearance, "Receptionist")) {
                main.ReceptionistPanel();
            }

            else if (Objects.equals(Clearance, "Housekeeper")) {
                main.HousekeeperPanel();
            }

            else if (Clearance == null && !Username.getText().equals("") && !Password.getText().equals("")) {
                errorText.setText("Incorrect username or password.");
                errorText.setVisible(true);
            }
        }
    }

    public void initialize(URL url, ResourceBundle rb) {

    }
}
