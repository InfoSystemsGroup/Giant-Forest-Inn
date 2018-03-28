package controllers;


import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import hotel.Main;
import hotel.Queries;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

// Controller class used for LoginGUI.fxml
public class LoginController implements Initializable {

    public static String Clearance;

    @FXML
    public JFXButton btnSignIn, btnCreateAccount = new JFXButton();

    @FXML
    public JFXTextField Username = new JFXTextField();

    @FXML
    public JFXPasswordField Password = new JFXPasswordField();


    public void handleButtonAction(ActionEvent event) throws Exception {

        if (event.getTarget() == btnSignIn) {
            Queries Db = new Queries();
            Db.LoginQuery(Username.getText(), Password.getText());

            Main main = new Main();

            if (Clearance.equals("Admin")) {
                main.AdminPanel();
            }

            else if (Clearance.equals("Receptionist")) {
                main.ReceptionistPanel();
            }

            else if (Clearance.equals("Housekeeper")) {
                main.HousekeeperPanel();
            }
        }
    }

    public void initialize(URL url, ResourceBundle rb) {

    }
}
