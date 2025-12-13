module com.universidad.tarea3 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.universidad.tarea3 to javafx.fxml;
    exports com.universidad.tarea3;
    exports com.universidad.tarea3.controller;
    opens com.universidad.tarea3.controller to javafx.fxml;
}