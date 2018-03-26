package hotel;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.Image;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {

    private double xOffset = 0;
    private double yOffset = 0;

    // Grabs initial FXML file and applies various attributes
    @Override
    public void start(final Stage primaryStage) throws Exception {
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.getIcons().add(new Image(this.getClass().getResourceAsStream("Images/icons8_Service_Bell_96px.png")));
        Parent root = FXMLLoader.load(getClass().getResource("../fxml/AdminGUI.fxml"));
        primaryStage.setScene(new Scene(root, 1366, 768));
        primaryStage.show();

        // Grabs coordinates of cursor click on top bar of GUI
        root.lookup("#topBorder").setOnMousePressed(event -> {
            xOffset = event.getSceneX();
            yOffset = event.getSceneY();
        });

        // Updates coordinates of GUI as mouse is dragged
        root.lookup("#topBorder").setOnMouseDragged(event -> {
            primaryStage.setX(event.getScreenX() - xOffset);
            primaryStage.setY(event.getScreenY() - yOffset);
        });

        // Terminates program when close button is pressed
        root.lookup("#btnClose").setOnMousePressed(event -> System.exit(1));

        // Iconifies GUI when minimize button is pressed
        root.lookup("#btnMinimize").setOnMousePressed(event -> primaryStage.setIconified(true));
    }

    // Launches the program
    public static void main(String[] args) {
        launch(args);
    }
}