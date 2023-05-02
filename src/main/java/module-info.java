module com.example.accomplish {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    opens com.example.accomplish to javafx.fxml;
    exports com.example.accomplish;
}