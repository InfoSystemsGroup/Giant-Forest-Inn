package hotel;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.Image;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {

    private static Parent root;

    protected static Stage loginStage;
    protected static Stage currentStage;

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

        moveGUI(loginStage);
        closeGUI(loginStage);
    }

    public void adminPanel() throws Exception {

        loginStage.hide();

        currentStage = new Stage();

        root = FXMLLoader.load(getClass().getResource("../fxml/AdminGUI.fxml"));

        currentStage.initStyle(StageStyle.UNDECORATED);
        currentStage.getIcons().add(new Image(this.getClass().getResourceAsStream("Images/icons8_Service_Bell_96px.png")));
        currentStage.setScene(new Scene(root, 1366, 768));
        currentStage.show();

        moveGUI(currentStage);
        closeGUI(currentStage);
    }

    public void receptionistPanel() throws Exception {

        loginStage.hide();

        currentStage = new Stage();

        root = FXMLLoader.load(getClass().getResource("../fxml/ReceptionistGUI.fxml"));

        currentStage.initStyle(StageStyle.UNDECORATED);
        currentStage.getIcons().add(new Image(this.getClass().getResourceAsStream("Images/icons8_Service_Bell_96px.png")));
        currentStage.setScene(new Scene(root, 1366, 768));
        currentStage.show();

        moveGUI(currentStage);
        closeGUI(currentStage);
    }

    public void housekeeperPanel() throws Exception {

        loginStage.hide();

        currentStage = new Stage();

        root = FXMLLoader.load(getClass().getResource("../fxml/HousekeeperGUI.fxml"));

        currentStage.initStyle(StageStyle.UNDECORATED);
        currentStage.getIcons().add(new Image(this.getClass().getResourceAsStream("Images/icons8_Service_Bell_96px.png")));
        currentStage.setScene(new Scene(root, 1366, 768));
        currentStage.show();

        moveGUI(currentStage);
        closeGUI(currentStage);
    }

    // Method handles dragging GUI
    private void moveGUI(Stage stage) {

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
    private void closeGUI(Stage stage) {

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