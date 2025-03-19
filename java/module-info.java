module org.projetogp.projeto_gp {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens org.projetogp.projeto_gp to javafx.fxml;
    exports org.projetogp.projeto_gp;
}