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
    private ImageView imgPerfil;

    @FXML
    private ImageView imgLupa;

    @FXML
    public void initialize() {
        carregarImagemLupa();
        carregarImagemPerfil();
    }

    private void carregarImagemLupa(){
        String imagemUrl = "https://img.icons8.com/m_outlined/512/FFFFFF/search.png";
        Image imageLupa = new Image(imagemUrl, true);
        imgLupa.setImage(imageLupa);

        imgLupa.setFitWidth(40);
        imgLupa.setFitHeight(40);
        imgLupa.setPreserveRatio(false);
    }

    private void carregarImagemPerfil() {
        String imageUrl = "https://www.estrelando.com.br/uploads/2016/03/04/cxhristian-bale-1457124975.jpg";
        Image image = new Image(imageUrl, true);
        imgPerfil.setImage(image);

        // Define o tamanho da imagem
        imgPerfil.setFitWidth(60);
        imgPerfil.setFitHeight(60);
        imgPerfil.setPreserveRatio(false); // Isso evita que a imagem fique fora do círculo

        // Criar um recorte circular e alinhar corretamente
        Circle clip = new Circle(30, 30, 30);
        imgPerfil.setClip(clip);

        // Ajustar a posição para evitar cortes desproporcionais
        imgPerfil.setSmooth(true);
        imgPerfil.setCache(true);
    }



    @FXML
    private void abrirCadastro() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/projetogp/projeto_gp/CadastroFuncionario.fxml"));
            Parent root = loader.load();

            CadastroFuncionarioController cadastroController = loader.getController();
            cadastroController.setJanelaInicialController(this);

            Stage cadastroStage = new Stage();
            cadastroStage.setScene(new Scene(root));
            cadastroStage.setTitle("Cadastro de Funcionário");
            cadastroStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void adicionarFuncionarioNaLista(String nome, String funcao) {
        Label novoFuncionario = new Label(nome + " - " + funcao);
        novoFuncionario.setStyle("-fx-text-fill: white; -fx-font-size: 14px;"); // Define cor e tamanho
        listaUsuarios.getChildren().add(novoFuncionario);
    }

}
