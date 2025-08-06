package com.armeria.sistema.modelo.Ventas;

import java.time.LocalDate;
import java.time.Period;

public class Cliente {
    private String dni;
    private String nombre;
    private String apellido;
    private LocalDate fechaNacimiento;
    private boolean tieneLicencia;
    private String direccion; 
    private TipoLicencia tipoLicencia;


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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public TipoLicencia getTipoLicencia() {
        return tipoLicencia;
    }

    public void setTipoLicencia(TipoLicencia tipoLicencia) {
        this.tipoLicencia = tipoLicencia;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public boolean isTieneLicencia() {
        return tieneLicencia;
    }

    public int calcularEdad() {
        return Period.between(this.fechaNacimiento, LocalDate.now()).getYears();
    }

    public String getDireccion() {
        return direccion;
    }
}
