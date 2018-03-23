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

    @Override
    public void start(final Stage primaryStage) throws Exception {
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.getIcons().add(new Image(this.getClass().getResourceAsStream("Images/icons8_Service_Bell_96px.png")));
        Parent root = FXMLLoader.load(getClass().getResource("../fxml/GUI.fxml"));
        root.getStylesheets().add(this.getClass().getResource("../stylesheets/styling.css").toExternalForm());
        primaryStage.setScene(new Scene(root, 1366, 768));
        primaryStage.show();

        root.lookup("#topBorder").setOnMousePressed(event -> {
            xOffset = event.getSceneX();
            yOffset = event.getSceneY();
        });

        root.lookup("#topBorder").setOnMouseDragged(event -> {
            primaryStage.setX(event.getScreenX() - xOffset);
            primaryStage.setY(event.getScreenY() - yOffset);
        });

        root.lookup("#btnClose").setOnMousePressed(event -> System.exit(1));

        root.lookup("#btnMinimize").setOnMousePressed(event -> primaryStage.setIconified(true));
    }

    public static void main(String[] args) {
        launch(args);
    }
}