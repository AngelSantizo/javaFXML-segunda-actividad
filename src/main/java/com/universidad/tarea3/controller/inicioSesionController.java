package com.universidad.tarea3.controller;

import com.universidad.tarea3.Application;
import com.universidad.tarea3.modulos.Conexion;
import com.universidad.tarea3.seguridad.PasswordUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class inicioSesionController {

    @FXML
    private Button registroBoton;

    @FXML
    private PasswordField contraInput;

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

        //pasamos el password otra vez en nuestro utils
        String passwordHash = PasswordUtils.hashPassword(password);

        //verficamos aqui ahora la base de datos
        String sql = "SELECT * FROM usuarios WHERE username = ? AND password = ?";

        try{
            Conexion conexion = new Conexion();
            PreparedStatement ps = conexion.getConexion().prepareStatement(sql);

            ps.setString(1, usuario);
            ps.setString(2, passwordHash);

            //guardamos el resultado en una variable
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                System.out.println("Acceso confirmado");
                aplicacion.abrirVentanaAsistencia();
            }else {
                mostrarError("Credenciales Invalidas");
            }

            rs.close();
            ps.close();
            conexion.close();

        } catch (SQLException e) {
            mostrarError("Error de conexion");
            throw new RuntimeException(e);
        }

    }

    //boton para abrir ventana de registro de usuarios
    @FXML
    void registroClick(ActionEvent event) {
        aplicacion.abrirRegistroVentana();
    }

}

