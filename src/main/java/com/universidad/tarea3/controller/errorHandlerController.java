package com.universidad.tarea3.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class errorHandlerController {

    @FXML
    private Label mensajeError;

    //metodo para setear mensaje
    public void setMensajeError(String mensaje){
        mensajeError.setText(mensaje);
    }

}