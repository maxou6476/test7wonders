module com.example._7wondersarchitect {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires com.almasb.fxgl.all;
    requires javafx.media;

    opens com.example._7wondersarchitect to javafx.fxml;
    exports com.example._7wondersarchitect;
}