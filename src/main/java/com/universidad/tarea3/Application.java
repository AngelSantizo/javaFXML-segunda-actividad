package com.universidad.tarea3;

import com.universidad.tarea3.controller.asistenciaController;
import com.universidad.tarea3.controller.detalleController;
import com.universidad.tarea3.controller.inicioSesionController;
import com.universidad.tarea3.modulos.Administrador;
import com.universidad.tarea3.modulos.Estudiante;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Application extends javafx.application.Application {
    //5 elementos de tipo estudiante
    Estudiante estudiante1 = new Estudiante("Alejandro", "1", 12, true);
    Estudiante estudiante2 = new Estudiante("Maria", "2", 13, true);
    Estudiante estudiante3 = new Estudiante("Sofia", "3", 12, false);
    Estudiante estudiante4 = new Estudiante("Brandon", "4", 12, true);
    Estudiante estudiante5 = new Estudiante("Camilo", "5", 12, false);

    //una variable tipo Administrador para el inicio de sesion
    public Administrador admin = new Administrador("admin","123abc");

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("inicio-sesion.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Hello!");
        stage.setScene(scene);

        //conectamos nuestro controlador de inicioSesion
        inicioSesionController sesionController = fxmlLoader.getController();
        sesionController.setAplication(this);
        stage.show();
    }

    //abrir una vez sea exitoso otra ventana
    public void abrirVentanaAsistencia (){
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("asistencia.fxml"));
            Parent root = loader.load();

            //controlador
            asistenciaController asistenciaControl = loader.getController();
            asistenciaControl.setAplication(this);
            asistenciaControl.setEstudiantes(estudiante1,estudiante2,estudiante3,estudiante4,estudiante5);

            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //tercera ventana de detalles
    public void abrirVentanaDetalles(Estudiante estudiante) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("detalle.fxml"));
            Parent root = loader.load();

            detalleController detalleControlador = loader.getController();
            detalleControlador.setEstudiante(estudiante);

            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

}
