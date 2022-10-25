module com.example.dict {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.dict to javafx.fxml;
    exports com.example.dict;
}