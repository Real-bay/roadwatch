package fi.tuni.roadwatch;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URISyntaxException;

public class RoadWatchApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException, URISyntaxException {

        Rectangle2D screenBounds = Screen.getPrimary().getBounds();
        FXMLLoader fxmlLoader = new FXMLLoader(RoadWatchApplication.class.getResource("fxml/roadwatch.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        final RoadWatchController roadWatchController = fxmlLoader.getController();
        SessionData sessionData = new SessionData();
        HelperFunctions helperFunctions = new HelperFunctions();
        WeatherAPILogic weatherAPILogic = new WeatherAPILogic();
        roadWatchController.setSessionData(sessionData);
        roadWatchController.setDates(helperFunctions);
        roadWatchController.loadMap();
        //roadWatchController.setScreenBounds(screenBounds);
        //roadWatchController.setScreenSize();

        stage.setTitle("RoadWatch");
        //stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}