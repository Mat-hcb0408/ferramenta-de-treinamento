package org.projetogp.projeto_gp;

import javafx.animation.FadeTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.Node;
import javafx.stage.Stage;
import javafx.util.Duration;

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

        // Aplica animação corretamente na lista suspensa
        aplicarTransicaoComboBox(cbFuncao);
        aplicarTransicaoComboBox(cbTreinamento);
        aplicarTransicaoComboBox(cbValidade);
    }

    private void aplicarTransicaoComboBox(ComboBox<String> comboBox) {
        comboBox.setOnShowing(event -> {
            // Pequeno atraso para garantir que a lista foi criada
            new Thread(() -> {
                try {
                    Thread.sleep(50); // Espera a UI atualizar
                } catch (InterruptedException ignored) {
                }

                // Executa na thread da UI
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

    @FXML
    private void cadastrarFuncionario() {
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

        if (janelaInicialController != null) {
            janelaInicialController.adicionarFuncionarioNaLista(nome, funcao);
        } else {
            System.out.println("Erro: Controlador da Janela Inicial não foi definido!");
        }

        System.out.println("------------------------------------------------");
        System.out.println("Funcionário Cadastrado:");
        System.out.println("Nome: " + nome);
        System.out.println("Email: " + email);
        System.out.println("Função: " + funcao);
        System.out.println("Treinamento: " + treinamento);
        System.out.println("Validade do Treinamento: " + validade);
        System.out.println("------------------------------------------------");

        Stage stage = (Stage) btnCadastrar.getScene().getWindow();
        stage.close();
    }
}
