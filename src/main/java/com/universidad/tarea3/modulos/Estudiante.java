package com.universidad.tarea3.modulos;

public class Estudiante {

    String nombre;
    String carnet;
    Integer grado;
    Boolean asistencia;

    public Estudiante(String nombre, String carnet, Integer grado, Boolean asistencia) {
        this.nombre = nombre;
        this.carnet = carnet;
        this.grado = grado;
        this.asistencia = asistencia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCarnet() {
        return carnet;
    }

    public void setCarnet(String carnet) {
        this.carnet = carnet;
    }

    public Integer getGrado() {
        return grado;
    }

    public void setGrado(Integer grado) {
        this.grado = grado;
    }

    public Boolean getAsistencia() {
        return asistencia;
    }

    public void setAsistencia(Boolean asistencia) {
        this.asistencia = asistencia;
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "nombre='" + nombre + '\'' +
                ", carnet='" + carnet + '\'' +
                ", grado=" + grado +
                ", asistencia=" + asistencia +
                '}';
    }
}
