module com.aloha {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.base;
    requires lombok;
    requires java.sql;

    opens com.aloha to javafx.graphics, javafx.fxml, java.sql;
    opens com.aloha.Controller to javafx.fxml;
    opens com.aloha.DTO to javafx.base;
    exports com.aloha;
}
