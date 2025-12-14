package com.universidad.tarea3.controller;


import com.universidad.tarea3.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class registroController {

    @FXML
    private Button botonCrear;

    @FXML
    private TextField passwordInput;

    @FXML
    private TextField usernameInput;

    //conectamos la Aplicacion aca
    private Application aplicacion;
    public void setAplication(Application application) {
        this.aplicacion = application;
    }

    @FXML
    void CrearClick(ActionEvent event) {

    }


}