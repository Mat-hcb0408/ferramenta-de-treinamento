package org.projetogp.projeto_gp;

import javafx.animation.FadeTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.Node;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.io.IOException;

public class CadastroFuncionarioController {

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtEmail;

    @FXML
    private ComboBox<String> cbFuncao;

    @FXML
    private ComboBox<String> cbTreinamento;

    @FXML
    private ComboBox<String> cbValidade;

    @FXML
    private Button btnCadastrar;

    @FXML
    private Button btnVoltar; // Botão para voltar

    private String paginaAnterior = "inicio"; // Define a página anterior (padrão: "inicio")

    private JanelaInicialController janelaInicialController;

    @FXML
    public void initialize() {
        ObservableList<String> funcoes = FXCollections.observableArrayList(
                "Operador de Máquina", "Técnico de Segurança", "Supervisor", "Engenheiro", "Auxiliar Administrativo"
        );
        cbFuncao.setItems(funcoes);

        ObservableList<String> treinamentos = FXCollections.observableArrayList(
                "Segurança no Trabalho", "Manutenção de Equipamentos", "Primeiros Socorros", "Normas Regulamentadoras"
        );
        cbTreinamento.setItems(treinamentos);

        ObservableList<String> validades = FXCollections.observableArrayList("Válido", "Vencido", "Não Possui");
        cbValidade.setItems(validades);

        aplicarTransicaoComboBox(cbFuncao);
        aplicarTransicaoComboBox(cbTreinamento);
        aplicarTransicaoComboBox(cbValidade);
    }

    private void aplicarTransicaoComboBox(ComboBox<String> comboBox) {
        comboBox.setOnShowing(event -> {
            new Thread(() -> {
                try {
                    Thread.sleep(50);
                } catch (InterruptedException ignored) {}

                javafx.application.Platform.runLater(() -> {
                    Node popup = comboBox.lookup(".list-view");
                    if (popup != null) {
                        popup.setOpacity(0);
                        FadeTransition fadeIn = new FadeTransition(Duration.seconds(2), popup);
                        fadeIn.setFromValue(0);
                        fadeIn.setToValue(1);
                        fadeIn.play();
                    }
                });
            }).start();
        });
    }

    public void setJanelaInicialController(JanelaInicialController controller) {
        this.janelaInicialController = controller;
    }

    public void setPaginaAnterior(String pagina) {
        this.paginaAnterior = pagina;
    }

    @FXML
    private void carregarTela(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/org/projetogp/projeto_gp/JanelaInicial.fxml"));
            Parent root = fxmlLoader.load();
            JanelaInicialController inicialController = fxmlLoader.getController();

            if (janelaInicialController != null) {
                inicialController = janelaInicialController;
            }

            Scene scene = ((Node) event.getSource()).getScene();
            scene.setRoot(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void cadastrarFuncionario(ActionEvent event) {
        String nome = txtNome.getText();
        String email = txtEmail.getText();
        String funcao = cbFuncao.getValue();
        String treinamento = cbTreinamento.getValue();
        String validade = cbValidade.getValue();

        if (nome.isEmpty() || email.isEmpty() || funcao == null || treinamento == null || validade == null) {
            Alert alerta = new Alert(Alert.AlertType.WARNING, "Preencha todos os campos!");
            alerta.show();
            return;
        }

        System.out.println("------------------------------------------------");
        System.out.println("Funcionário Cadastrado:");
        System.out.println("Nome: " + nome);
        System.out.println("Email: " + email);
        System.out.println("Função: " + funcao);
        System.out.println("Treinamento: " + treinamento);
        System.out.println("Validade do Treinamento: " + validade);
        System.out.println("------------------------------------------------");

        if (janelaInicialController != null) {
            janelaInicialController.adicionarFuncionarioNaLista(nome, funcao);
        }

        carregarTela(event);
    }
}