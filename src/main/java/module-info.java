module com.example.accomplish {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.example.accomplish to javafx.fxml;
    exports com.example.accomplish;
}