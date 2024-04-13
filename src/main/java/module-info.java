module org.example.comp228lab4 {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.comp228lab4 to javafx.fxml;
    exports org.example.comp228lab4;
}