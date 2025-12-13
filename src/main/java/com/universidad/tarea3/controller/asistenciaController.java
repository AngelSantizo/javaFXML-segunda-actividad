package com.universidad.tarea3.controller;

import com.universidad.tarea3.modulos.Estudiante;
import com.universidad.tarea3.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.ListView;

public class asistenciaController {

    @FXML
    private ListView<String> listView;

    @FXML
    private PieChart pieChart;

    //conectamos la Aplicacion aca
    private Application aplicacion;
    public void setAplication(Application application) {
        this.aplicacion = application;
    }

    //creamos un array de estudiantes
    private Estudiante[] estudiantes;

    //recibimos la info
    public void setEstudiantes(Estudiante... estudiante){
        this.estudiantes = estudiante;

        cargarLista();
    }

    private void cargarLista(){
        if (estudiantes == null) return; // evita errores

        listView.getItems().clear();

        //recorremos el array
        for(Estudiante e: estudiantes){
            listView.getItems().add(e.getNombre());
        }

        //cargamos el pieChart tambien
        setPieChart();
    }

    private void setPieChart(){
        int asistieron = 0;
        int noAsistieron = 0;

        for (Estudiante e : estudiantes){
            if(e.getAsistencia()){
                asistieron++;
            }else{
                noAsistieron++;
            }
        }

        pieChart.getData().clear();;
        pieChart.getData().add(new PieChart.Data("Asistieron", asistieron));
        pieChart.getData().add(new PieChart.Data("No asistieron", noAsistieron));
    }

    //cuando den click al elemento debe abrir la tercera ventana de detalles
    @FXML
    private void initialize() {
        listView.setOnMouseClicked(event -> {
            int index = listView.getSelectionModel().getSelectedIndex();
            if (index >= 0) {
                Estudiante seleccionado = estudiantes[index];
                aplicacion.abrirVentanaDetalles(seleccionado);
            }
        });
    }
}
