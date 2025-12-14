package com.universidad.tarea3.controller;


import com.universidad.tarea3.Application;
import com.universidad.tarea3.modulos.Conexion;
import com.universidad.tarea3.seguridad.PasswordUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.sql.PreparedStatement;
import java.sql.SQLException;

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

        //obtenemos el texto de ambos campos
        String username = usernameInput.getText();
        String password = passwordInput.getText();

        //verificamos que no esten vacios los campos
        if (username.isEmpty() || password.isEmpty()) {
            System.out.println("Campos vacíos");
            return;
        }

        //usamos el hash de nuestro passwordUtils
        String passwordHash = PasswordUtils.hashPassword(password);

        //Preparamos el statement
        String sql = "INSERT INTO usuarios (username, password) VALUES (?, ?)";

        try{
            //abrimos la conexion unicamente aca
            Conexion conexion = new Conexion();
            PreparedStatement ps = conexion.getConexion().prepareStatement(sql);

            ps.setString(1, username);
            ps.setString(2, passwordHash);

            //cerramos la  conexion
            ps.executeUpdate();
            ps.close();
            conexion.close();

            System.out.println("Usuario registrado correctamente");
        }catch (SQLException e){
            System.out.println("Error al registrar el usuario");
            e.printStackTrace();
        }
    }


}