module org.example.db {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.db to javafx.fxml;
    exports org.example.db;
}