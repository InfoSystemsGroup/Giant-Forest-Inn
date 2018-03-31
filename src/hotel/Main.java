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

    // Method loads LoginGUI FXML file and applies various attributes
    @Override
    public void start(final Stage primaryStage) throws Exception {

        root = FXMLLoader.load(getClass().getResource("../fxml/LoginGUI.fxml"));

        loginStage = primaryStage;
        loginStage.initStyle(StageStyle.UNDECORATED);
        loginStage.getIcons().add(new Image(this.getClass().getResourceAsStream("Images/icons8_Service_Bell_96px.png")));
        loginStage.setScene(new Scene(root, 1046, 736));
        loginStage.show();

        moveGUI(loginStage);
        closeGUI(loginStage);
    }

    // Method hides LoginGUI, loads AdminGUI FXML file and applies various attributes
    public void adminGUI() throws Exception {

        loginStage.hide();

        root = FXMLLoader.load(getClass().getResource("../fxml/AdminGUI.fxml"));

        currentStage = new Stage();
        currentStage.initStyle(StageStyle.UNDECORATED);
        currentStage.getIcons().add(new Image(this.getClass().getResourceAsStream("Images/icons8_Service_Bell_96px.png")));
        currentStage.setScene(new Scene(root, 1366, 768));
        currentStage.show();

        moveGUI(currentStage);
        closeGUI(currentStage);
    }

    // Method hides LoginGUI, loads ReceptionistGUI FXML file and applies various attributes
    public void receptionistGUI() throws Exception {

        loginStage.hide();

        root = FXMLLoader.load(getClass().getResource("../fxml/ReceptionistGUI.fxml"));

        currentStage = new Stage();
        currentStage.initStyle(StageStyle.UNDECORATED);
        currentStage.getIcons().add(new Image(this.getClass().getResourceAsStream("Images/icons8_Service_Bell_96px.png")));
        currentStage.setScene(new Scene(root, 1366, 768));
        currentStage.show();

        moveGUI(currentStage);
        closeGUI(currentStage);
    }

    // Method hides LoginGUI, loads HousekeeperGUI FXML file and applies various attributes
    public void housekeeperGUI() throws Exception {

        loginStage.hide();

        root = FXMLLoader.load(getClass().getResource("../fxml/HousekeeperGUI.fxml"));

        currentStage = new Stage();
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