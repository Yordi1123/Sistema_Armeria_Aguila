package com.armeria.sistema.modelo.Pago;

import com.armeria.sistema.modelo.Ventas.Cliente;

import java.time.LocalDateTime;

public class Pago {
    private Cliente cliente;
    private MetodoPagoEnum metodoPago; // Ejemplo: "Tarjeta de Crédito", "Efectivo", etc.
    private double monto;
    private boolean valido;
    private LocalDateTime fechaPago;

    public Pago(Cliente cliente, double monto) {
        this.cliente = cliente;
        this.monto = monto;
    }

    // Métodos Getter y Setter
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public MetodoPagoEnum getMetodoPago() {
        return metodoPago;
    }

    public void setMetodo(MetodoPagoEnum metodoPago) {
        this.metodoPago = metodoPago;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public LocalDateTime getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(LocalDateTime fechaPago) {
        this.fechaPago = fechaPago;
    }

    public boolean isValido() {
        return valido;
    }

    public void setValido(boolean valido) {
        this.valido = valido;
    }
}
