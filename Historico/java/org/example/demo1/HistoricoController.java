package org.example.demo1;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;

public class HistoricoController {

    @FXML
    private Label lblNome;

    @FXML
    private Label lblAviso;

    @FXML
    private VBox vboxHistoricoFeitos1, vboxHistoricoPendentes1;
    @FXML
    private VBox vboxHistoricoFeitos2, vboxHistoricoPendentes2;
    @FXML
    private VBox vboxHistoricoFeitos3, vboxHistoricoPendentes3;

    // Listas de históricos feitos e pendentes
    private List<Historico> historicoFeitoGuilherme = new ArrayList<>();
    private List<Historico> historicoPendenteGuilherme = new ArrayList<>();

    private List<Historico> historicoFeitoAna = new ArrayList<>();
    private List<Historico> historicoPendenteAna = new ArrayList<>();

    private List<Historico> historicoFeitoCarlos = new ArrayList<>();
    private List<Historico> historicoPendenteCarlos = new ArrayList<>();

    // Inicializa os históricos com dados fictícios
    public HistoricoController() {
        // Históricos de Guilherme
        historicoFeitoGuilherme.add(new Historico("15/02/2025", "Treinamento de Java", "100%", "feito"));
        historicoFeitoGuilherme.add(new Historico("10/03/2025", "Treinamento de Spring", "80%", "feito"));
        historicoPendenteGuilherme.add(new Historico("01/04/2025", "Treinamento de Angular", "0%", "pendente"));

        // Históricos de Ana
        historicoFeitoAna.add(new Historico("20/03/2025", "Treinamento de Python", "95%", "feito"));
        historicoFeitoAna.add(new Historico("15/03/2025", "Treinamento de SQL", "90%", "feito"));
        historicoPendenteAna.add(new Historico("22/03/2025", "Treinamento de React", "0%", "pendente"));

        // Históricos de Carlos
        historicoFeitoCarlos.add(new Historico("17/03/2025", "Treinamento de SQL", "85%", "feito"));
        historicoFeitoCarlos.add(new Historico("10/03/2025", "Treinamento de Docker", "88%", "feito"));
        historicoPendenteCarlos.add(new Historico("25/03/2025", "Treinamento de Kubernetes", "0%", "pendente"));
    }

    // Atualizar o perfil 1 (Guilherme Roxa)
    @FXML
    private void atualizarPerfil1() {
        lblNome.setText("Guilherme Rocha");
        lblAviso.setText("AVISO! \n Último treinamento feito em 22/02/2069");
        mostrarHistorico(vboxHistoricoFeitos1, historicoFeitoGuilherme);
        mostrarHistorico(vboxHistoricoPendentes1, historicoPendenteGuilherme);
    }

    // Atualizar o perfil 2 (Ana Souza)
    @FXML
    private void atualizarPerfil2() {
        lblNome.setText("Ana Souza");
        lblAviso.setText("AVISO!\nÚltimo treinamento feito em 20/03/2025");
        mostrarHistorico(vboxHistoricoFeitos2, historicoFeitoAna);
        mostrarHistorico(vboxHistoricoPendentes2, historicoPendenteAna);
    }

    // Atualizar o perfil 3 (Carlos Pereira)
    @FXML
    private void atualizarPerfil3() {
        lblNome.setText("Carlos Pereira");
        lblAviso.setText("AVISO!\nÚltimo treinamento feito em 18/03/2025");
        mostrarHistorico(vboxHistoricoFeitos3, historicoFeitoCarlos);
        mostrarHistorico(vboxHistoricoPendentes3, historicoPendenteCarlos);
    }

    // Método para exibir os históricos feitos e pendentes
    private void mostrarHistorico(VBox vbox, List<Historico> historico) {
        vbox.getChildren().clear(); // Limpa os registros anteriores

        for (Historico h : historico) {
            Label label = new Label("Data: " + h.getData() + ", Descrição: " + h.getDescricao() + ", Valor: " + h.getValor() + " - Status: " + h.getStatus());
            vbox.getChildren().add(label);
        }
    }
}
