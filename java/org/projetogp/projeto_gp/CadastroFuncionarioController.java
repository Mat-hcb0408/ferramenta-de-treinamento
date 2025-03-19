package org.projetogp.projeto_gp;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;

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
    }

    // Método para passar o controlador da Janela Inicial
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

        // Usa a referência para adicionar o funcionário na lista
        if (janelaInicialController != null) {
            janelaInicialController.adicionarFuncionarioNaLista(nome, funcao);
        } else {
            System.out.println("Erro: Controlador da Janela Inicial não foi definido!");
        }

        // Fecha a janela de cadastro
        Stage stage = (Stage) btnCadastrar.getScene().getWindow();
        stage.close();
    }
}
