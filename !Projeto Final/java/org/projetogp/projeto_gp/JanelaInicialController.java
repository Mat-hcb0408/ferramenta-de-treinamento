package org.projetogp.projeto_gp;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.io.IOException;

public class JanelaInicialController {

    @FXML
    public StackPane imgPerfilContainer;

    @FXML
    private TextField txtPesquisa;

    @FXML
    private VBox listaUsuarios;

    @FXML
    private Button btnAdicionar;

    @FXML
    private Button btnHistorico;

    @FXML
    private ImageView imgLupa;

    @FXML
    private ImageView imgPerfil;

    @FXML
    public void initialize() {
        carregarImagemPerfil();
        carregarImagemLupa();
    }

    private void carregarImagemLupa(){
        String imageUrl = "https://www.pngkey.com/png/full/87-872187_lupa-search-icon-white-png.png";
        Image image = new Image(imageUrl, true);
        imgLupa.setImage(image);
    }

    private void carregarImagemPerfil() {
        String imageUrl = "https://i.pinimg.com/236x/55/6e/2e/556e2edc7518c0e5cb4d59aef6729b24.jpg";
        Image image = new Image(imageUrl, true);
        imgPerfil.setImage(image);

        // Define o tamanho da imagem
        imgPerfil.setFitWidth(60);
        imgPerfil.setFitHeight(60);
        imgPerfil.setPreserveRatio(false);

        // Criar um recorte circular e alinhar corretamente
        Circle clip = new Circle(30, 30, 30);
        imgPerfil.setClip(clip);

        // Ajustar a posição para evitar cortes desproporcionais
        imgPerfil.setSmooth(true);
        imgPerfil.setCache(true);
    }

    @FXML
    private void trocarTela(String fxml, String paginaAnterior) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
            Parent novaCena = loader.load();

            // Se for a tela de cadastro, passa a referência da tela inicial
            if (fxml.contains("CadastroFuncionario.fxml")) {
                CadastroFuncionarioController cadastroController = loader.getController();
                cadastroController.setJanelaInicialController(this); // PASSA A REFERÊNCIA
                cadastroController.setPaginaAnterior(paginaAnterior);
            }

            Stage stage = (Stage) txtPesquisa.getScene().getWindow(); // Obtém o Stage atual
            stage.getScene().setRoot(novaCena); // Define a nova tela na mesma cena
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @FXML
    private void abrirCadastro() {
        trocarTela("/org/projetogp/projeto_gp/CadastroFuncionario.fxml", "inicio");
    }

    @FXML
    private void abrirHistorico() {
        trocarTela("/org/projetogp/projeto_gp/Historico.fxml", "inicio");
    }

    public void adicionarFuncionarioNaLista(String nome, String funcao) {
        Label novoFuncionario = new Label(nome + " - " + funcao);
        novoFuncionario.setStyle("-fx-text-fill: white; -fx-font-size: 14px;");
        listaUsuarios.getChildren().add(novoFuncionario);
    }
}
