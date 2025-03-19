package org.projetogp.projeto_gp;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.VBox;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;

import java.io.IOException;

public class JanelaInicialController {

    @FXML
    private TextField txtPesquisa;

    @FXML
    private VBox listaUsuarios;

    @FXML
    private Button btnAdicionar;

    @FXML
    private ImageView imgPerfil;

    @FXML
    public void initialize() {
        // Estilização dinâmica do botão ao passar o mouse
        btnAdicionar.setOnMouseEntered(e -> btnAdicionar.setStyle("-fx-background-color: #0000FF; -fx-text-fill: white;"));
        btnAdicionar.setOnMouseExited(e -> btnAdicionar.setStyle("-fx-background-color: black; -fx-text-fill: white;"));

        // Carrega a imagem do perfil
        String imageUrl = "https://plataforma.gpinovacao.senai.br/plataforma/media/upload/fotos/1275531327664b8879e9dea7.75332643--whatsapp-image-2024-05-20-at-141212jpeg.jpeg_170x142.jpeg";
        Image image = new Image(imageUrl, true);
        imgPerfil.setImage(image);
        double radius = Math.min(imgPerfil.getFitWidth(), imgPerfil.getFitHeight()) / 2;
        Circle clip = new Circle(imgPerfil.getFitWidth() / 2, imgPerfil.getFitHeight() / 2, radius);
        imgPerfil.setClip(clip);

        // Configurar tamanho da imagem
        imgPerfil.setFitWidth(60);
        imgPerfil.setFitHeight(60);
        imgPerfil.setPreserveRatio(false);

        btnAdicionar.setOnMouseEntered(e -> btnAdicionar.setStyle(
                "-fx-background-color: #0056b3;" +  // Azul mais escuro ao passar o mouse
                        "-fx-text-fill: white;" +
                        "-fx-font-size: 16px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-background-radius: 50px;" +
                        "-fx-padding: 10 20;" +
                        "-fx-min-width: 150px;" +
                        "-fx-cursor: hand;" +
                        "-fx-effect: dropshadow(three-pass-box, rgba(0, 0, 255, 0.7), 12, 0, 0, 5);"
        ));

        btnAdicionar.setOnMouseExited(e -> btnAdicionar.setStyle(
                "-fx-background-color: #007BFF;" +  // Volta para azul normal
                        "-fx-text-fill: white;" +
                        "-fx-font-size: 16px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-background-radius: 50px;" +
                        "-fx-padding: 10 20;" +
                        "-fx-min-width: 150px;" +
                        "-fx-cursor: hand;" +
                        "-fx-effect: dropshadow(three-pass-box, rgba(0, 0, 255, 0.5), 10, 0, 0, 4);"
        ));
    }

    // Método correto para abrir a tela de cadastro sem perder a instância atual
    @FXML
    private void abrirCadastro() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/projetogp/projeto_gp/CadastroFuncionario.fxml"));
            Parent root = loader.load();

            // Obtém o controlador do CadastroFuncionarioController
            CadastroFuncionarioController cadastroController = loader.getController();
            cadastroController.setJanelaInicialController(this); // Passa a instância atual

            // Abre uma nova janela para o cadastro
            Stage cadastroStage = new Stage();
            cadastroStage.setScene(new Scene(root));
            cadastroStage.setTitle("Cadastro de Funcionário");
            cadastroStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para adicionar um funcionário na lista
    public void adicionarFuncionarioNaLista(String nome, String funcao) {
        Label novoFuncionario = new Label(nome + " - " + funcao);
        novoFuncionario.setStyle("-fx-text-fill: white; -fx-font-size: 14px; -fx-padding: 5;");
        listaUsuarios.getChildren().add(novoFuncionario);
    }
}
