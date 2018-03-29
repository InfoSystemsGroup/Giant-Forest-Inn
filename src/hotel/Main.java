package hotel;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.Image;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {

    public static Stage loginStage;

    public static Parent root;

    private double xOffset = 0;
    private double yOffset = 0;

    // Method grabs initial FXML file and applies various attributes
    @Override
    public void start(final Stage primaryStage) throws Exception {

        loginStage = primaryStage;

        root = FXMLLoader.load(getClass().getResource("../fxml/LoginGUI.fxml"));

        loginStage.initStyle(StageStyle.UNDECORATED);
        loginStage.getIcons().add(new Image(this.getClass().getResourceAsStream("Images/icons8_Service_Bell_96px.png")));
        loginStage.setScene(new Scene(root, 1046, 736));
        loginStage.show();

        closeGUI(loginStage);
    }

    public void AdminPanel() throws Exception {

        loginStage.hide();

        Stage Admin = new Stage();

        root = FXMLLoader.load(getClass().getResource("../fxml/AdminGUI.fxml"));

        Admin.initStyle(StageStyle.UNDECORATED);
        Admin.getIcons().add(new Image(this.getClass().getResourceAsStream("Images/icons8_Service_Bell_96px.png")));
        Admin.setScene(new Scene(root, 1366, 768));
        Admin.show();

        moveGUI(Admin);
        closeGUI(Admin);
    }

    public void ReceptionistPanel() throws Exception {

        loginStage.hide();

        Stage Receptionist = new Stage();

        root = FXMLLoader.load(getClass().getResource("../fxml/ReceptionistGUI.fxml"));

        Receptionist.initStyle(StageStyle.UNDECORATED);
        Receptionist.getIcons().add(new Image(this.getClass().getResourceAsStream("Images/icons8_Service_Bell_96px.png")));
        Receptionist.setScene(new Scene(root, 1366, 768));
        Receptionist.show();

        moveGUI(Receptionist);
        closeGUI(Receptionist);
    }

    public void HousekeeperPanel() throws Exception {

        loginStage.hide();

        Stage Housekeeper = new Stage();

        root = FXMLLoader.load(getClass().getResource("../fxml/HousekeeperGUI.fxml"));

        Housekeeper.initStyle(StageStyle.UNDECORATED);
        Housekeeper.getIcons().add(new Image(this.getClass().getResourceAsStream("Images/icons8_Service_Bell_96px.png")));
        Housekeeper.setScene(new Scene(root, 1366, 768));
        Housekeeper.show();

        moveGUI(Housekeeper);
        closeGUI(Housekeeper);
    }

    // Method handles dragging GUI
    public void moveGUI(Stage stage) {

        // Grabs coordinates of cursor click on top bar of GUI
        root.lookup("#topBorder").setOnMousePressed(event -> {
            xOffset = event.getSceneX();
            yOffset = event.getSceneY();
        });

        // Updates coordinates of GUI as mouse is dragged
        root.lookup("#topBorder").setOnMouseDragged(event -> {
            stage.setX(event.getScreenX() - xOffset);
            stage.setY(event.getScreenY() - yOffset);
        });
    }

    // Method handles closing or iconifying GUI
    public void closeGUI(Stage stage) {

        // Terminates program when close button is pressed
        root.lookup("#btnClose").setOnMousePressed(event -> System.exit(1));

        // Iconifies GUI when minimize button is pressed
        root.lookup("#btnMinimize").setOnMousePressed(event -> stage.setIconified(true));
    }

    // Launches the program
    public static void main(String[] args) {
        launch(args);
    }
}