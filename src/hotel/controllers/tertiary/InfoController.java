package hotel.controllers.tertiary;

import com.jfoenix.controls.JFXButton;
import hotel.main.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class InfoController extends Main {

    @FXML public Text txtInfo;
    @FXML public JFXButton btnOkay;
    @FXML public AnchorPane infoPane;

    public void handleButtonAction(ActionEvent event) {

        if (event.getTarget() == btnOkay)
            infoPane.setVisible(false);
    }

    public void populateText(String info) throws Exception{

        informationGUI();

        txtInfo.setText(info);
    }
}
