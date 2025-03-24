package org.example.demo1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        // Carrega o arquivo FXML
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Historico.fxml"));
        StackPane root = fxmlLoader.load();  // Carrega o FXML
        Scene scene = new Scene(root, 600, 400);  // Cria a cena com o layout
        stage.setScene(scene);  // Configura a cena
        stage.show();  // Exibe o palco
    }

    public static void main(String[] args) {
        launch();
    }
}
