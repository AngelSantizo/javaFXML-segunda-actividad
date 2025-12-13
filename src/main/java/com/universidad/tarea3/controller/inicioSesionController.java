package com.universidad.tarea3.controller;

import com.universidad.tarea3.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class inicioSesionController {

    @FXML
    private TextField contraInput;

    @FXML
    private TextField nombreInput;

    //conectamos la Aplicacion aca
    private Application aplicacion;
    public void setAplication(Application application) {
        this.aplicacion = application;
    }

    //creamos una ventana de error
    private void mostrarError(String mensaje){
        try {
            FXMLLoader loader = new FXMLLoader(Application.class.getResource("errorHandler.fxml"));
            Scene escenaError = new Scene(loader.load());

            errorHandlerController errorController = loader.getController();
            //le pasaremos aqui el mensaje para el metodo que tiene
            errorController.setMensajeError(mensaje);

            Stage stageError = new Stage();
            stageError.setTitle("Error");
            stageError.setScene(escenaError);
            stageError.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void botonClick(ActionEvent event) {
        String usuario = nombreInput.getText();
        String password = contraInput.getText();

        if (usuario.isEmpty() || password.isEmpty()) {
            mostrarError("No pueden haber campos vacios");
            return;
        }

        if(usuario.equals(aplicacion.admin.getNombre()) && password.equals(aplicacion.admin.getPassword())){
            System.out.println("Acceso confirmado");

            //si funciona, entonces abrimos la ventana de Asistencia
            aplicacion.abrirVentanaAsistencia();
        }else{
            System.out.println("Acceso denegado");
            mostrarError("Datos no validos");
        }

    }

}

