package com.universidad.tarea3.modulos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    public Connection conexion = null;
    private String url = "jdbc:sqlite:directorio.db";

    public Conexion(){
        if(conexion == null){
            try {
                Class.forName("org.sqlite.JDBC");
                conexion = (Connection) DriverManager.getConnection(this.url);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }
    }

    public Connection getConexion(){
        return this.conexion;
    }

    public void close(){
        try {
            conexion.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}