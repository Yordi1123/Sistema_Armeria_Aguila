package com.armeria.sistema.modelo.Mediador;

import com.armeria.sistema.modelo.Ventas.Cliente;

public class Mensaje {
    private Cliente cliente;
    private double monto;
    private String descripcion;
    private boolean validacion;

    public Mensaje(Cliente cliente, double monto, String descripcion) {
        this.cliente = cliente;
        this.monto = monto;
        this.descripcion = descripcion;
    }

    public Mensaje(boolean validacion, String descripcion) {
        this.validacion = validacion;
        this.descripcion = descripcion;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
