package org.ativ12.ativ12;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class MainController {

    @FXML
    private VBox completedTrainingsList;

    @FXML
    private VBox pendingTrainingsList;

    @FXML
    private void initialize() {
        // Simulando treinamentos concluídos
        String[] completedTrainings = {"Java Básico", "POO em Java", "JavaFX Avançado"};
        String[] pendingTrainings = {"Banco de Dados", "Spring Boot", "Design Patterns"};

        // Adiciona os concluídos na lista
        for (String training : completedTrainings) {
            Label label = new Label(training);
            label.setStyle("-fx-background-color: lightgreen; -fx-padding: 5; -fx-border-radius: 5;");
            completedTrainingsList.getChildren().add(label);
        }

        // Adiciona os pendentes na lista
        for (String training : pendingTrainings) {
            Label label = new Label(training);
            label.setStyle("-fx-background-color: lightcoral; -fx-padding: 5; -fx-border-radius: 5;");
            pendingTrainingsList.getChildren().add(label);
        }
    }

    @FXML
    private void handleBack() {
        System.out.println("Voltando...");
    }

    @FXML
    private void handleMenu() {
        System.out.println("Abrindo menu...");
    }
}
