package com.universidad.tarea3.controller;

import com.universidad.tarea3.modulos.Estudiante;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class detalleController {

    @FXML
    private TextField asistenciaField;

    @FXML
    private TextField carnetField;

    @FXML
    private TextField gradoField;

    @FXML
    private TextField nombreField;

    private Estudiante estudiante;

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
        cargarDatos();
    }

    @FXML
    public void cargarDatos(){
        nombreField.setText(estudiante.getNombre());
        carnetField.setText(estudiante.getCarnet());
        gradoField.setText(String.valueOf(estudiante.getGrado()));
        asistenciaField.setText(estudiante.getAsistencia() ? "Asistio" : "No Asistio");
    }

}
