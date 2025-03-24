package org.example.demo1;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class HistoricoController implements Initializable {

    @FXML
    private ImageView profileImage1, profileImage2, profileImage3;

    @FXML
    private Label lblNome, lblAviso;

    @FXML
    private VBox vboxHistoricoFeitos1, vboxHistoricoPendentes1;
    @FXML
    private VBox vboxHistoricoFeitos2, vboxHistoricoPendentes2;
    @FXML
    private VBox vboxHistoricoFeitos3, vboxHistoricoPendentes3;

    private final List<Historico> historicoFeitoGuilherme = new ArrayList<>();
    private final List<Historico> historicoPendenteGuilherme = new ArrayList<>();
    private final List<Historico> historicoFeitoAna = new ArrayList<>();
    private final List<Historico> historicoPendenteAna = new ArrayList<>();
    private final List<Historico> historicoFeitoCarlos = new ArrayList<>();
    private final List<Historico> historicoPendenteCarlos = new ArrayList<>();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        carregarDados();
        carregarImagens();
    }

    // Classe interna para armazenar os dados
    private static class Historico {
        private final String data;
        private final String descricao;
        private final String valor;
        private final String status;

        public Historico(String data, String descricao, String valor, String status) {
            this.data = data;
            this.descricao = descricao;
            this.valor = valor;
            this.status = status;
        }
    }

    private void carregarDados() {
        historicoFeitoGuilherme.add(new Historico("15/02/2025", "Treinamento de Java", "100%", "feito"));
        historicoFeitoGuilherme.add(new Historico("10/03/2025", "Treinamento de Spring", "80%", "feito"));
        historicoPendenteGuilherme.add(new Historico("01/04/2025", "Treinamento de Angular", "0%", "pendente"));

        historicoFeitoAna.add(new Historico("20/03/2025", "Treinamento de Python", "95%", "feito"));
        historicoFeitoAna.add(new Historico("15/03/2025", "Treinamento de SQL", "90%", "feito"));
        historicoPendenteAna.add(new Historico("22/03/2025", "Treinamento de React", "0%", "pendente"));

        historicoFeitoCarlos.add(new Historico("17/03/2025", "Treinamento de SQL", "85%", "feito"));
        historicoFeitoCarlos.add(new Historico("10/03/2025", "Treinamento de Docker", "88%", "feito"));
        historicoPendenteCarlos.add(new Historico("25/03/2025", "Treinamento de Kubernetes", "0%", "pendente"));
    }

    private void carregarImagens() {
        setProfileImage(profileImage1, "https://avatars.fastly.steamstatic.com/54943af8f0f6eb25cc2b442e46c15926e28bda54_full.jpg");
        setProfileImage(profileImage2, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSwR7rVpWO0B7F3InfCMrcDG_gQwl-3TE_CMw&s");
        setProfileImage(profileImage3, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTguvjjIyvdlLEvneOVsGUjbpmDfVdZ5fJdEg&s");
    }

    private void setProfileImage(ImageView imageView, String imageUrl) {
        Image image = new Image(imageUrl, true);
        imageView.setImage(image);

        image.progressProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal.doubleValue() == 1.0) { // Imagem carregada
                double radius = Math.min(imageView.getFitWidth(), imageView.getFitHeight()) / 2;
                Circle clip = new Circle(radius);
                clip.setCenterX(radius);
                clip.setCenterY(radius);
                imageView.setClip(clip);
            }
        });
    }

    @FXML
    private void atualizarPerfil1() {
        atualizarPerfil("Guilherme Rocha", "22/02/2069", vboxHistoricoFeitos1, vboxHistoricoPendentes1, historicoFeitoGuilherme, historicoPendenteGuilherme);
    }

    @FXML
    private void atualizarPerfil2() {
        atualizarPerfil("Ana Souza", "20/03/2025", vboxHistoricoFeitos2, vboxHistoricoPendentes2, historicoFeitoAna, historicoPendenteAna);
    }

    @FXML
    private void atualizarPerfil3() {
        atualizarPerfil("Carlos Pereira", "18/03/2025", vboxHistoricoFeitos3, vboxHistoricoPendentes3, historicoFeitoCarlos, historicoPendenteCarlos);
    }

    private void atualizarPerfil(String nome, String ultimaData, VBox vboxFeitos, VBox vboxPendentes, List<Historico> feitos, List<Historico> pendentes) {
        lblNome.setText(nome);
        lblAviso.setText("AVISO!\nÚltimo treinamento feito em " + ultimaData);
        mostrarHistorico(vboxFeitos, feitos);
        mostrarHistorico(vboxPendentes, pendentes);
    }

    private void mostrarHistorico(VBox vbox, List<Historico> historico) {
        vbox.getChildren().clear();
        for (Historico h : historico) {
            Label label = new Label("Data: " + h.data + ", Descrição: " + h.descricao + ", Valor: " + h.valor + " - Status: " + h.status);
            label.getStyleClass().add(h.status.equals("feito") ? "label-status-feito" : "label-status-pendente");
            vbox.getChildren().add(label);
        }
    }
}
