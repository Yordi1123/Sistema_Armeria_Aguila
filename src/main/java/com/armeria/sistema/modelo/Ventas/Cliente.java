package com.armeria.sistema.modelo.Ventas;
import java.time.LocalDate;
import java.util.List;

public class Cliente {
    private String dni;
    private String nombre;
    private String apellido;
    private boolean tieneLicencia;
    //private List<Venta> historialVentas;

    public Cliente(String dni, String nombre, String apellido, boolean tieneLicencia) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.tieneLicencia = tieneLicencia;
    }


    //Metodos metodos Getter y Setter
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public boolean isTieneLicencia() {
        return tieneLicencia;
    }

    public void setTieneLicencia(boolean tieneLicencia) {
        this.tieneLicencia = tieneLicencia;
    }

}
