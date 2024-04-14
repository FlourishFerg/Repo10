module com.example.repo10 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.repo10 to javafx.fxml;
    exports com.example.repo10;
}