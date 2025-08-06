package com.armeria.sistema.modelo.Mediador;

import com.armeria.sistema.modelo.Pago.Pago;
import com.armeria.sistema.modelo.Ventas.Cliente;

public class Mensaje {
    private Cliente cliente;
    private double monto;
    private String descripcion;
    private Pago pago;

    public Mensaje() {
    }

    public Mensaje(Cliente cliente, double monto, String descripcion) {
        this.cliente = cliente;
        this.monto = monto;
        this.descripcion = descripcion;
    }

    public Mensaje(Pago pago, String descripcion) {
        this.pago= pago;
        this.descripcion = descripcion;
    }

    public Cliente getCliente() {
        return cliente;
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

    public Pago getPago() {
        return pago;
    }
}
