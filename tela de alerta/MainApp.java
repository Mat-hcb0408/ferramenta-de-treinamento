package org.ativ12.ativ12;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/org/ativ12/ativ12/alert_screen.fxml"));
        BorderPane root = fxmlLoader.load();

        Scene scene = new Scene(root, 400, 600);
        primaryStage.setTitle("Tela de Alerta");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
