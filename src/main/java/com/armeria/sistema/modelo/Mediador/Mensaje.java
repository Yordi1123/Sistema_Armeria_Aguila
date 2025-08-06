package com.armeria.sistema.modelo.Mediador;

import com.armeria.sistema.modelo.Pago.Pago;
import com.armeria.sistema.modelo.Ventas.CarritoCompra;
import com.armeria.sistema.modelo.Ventas.Cliente;

public class Mensaje {
    private Cliente cliente;
    private double monto;
    private String descripcion;
    private Pago pago;
    private CarritoCompra carrito;

    public Mensaje() {
    }

    //Constructor para enviar a pago
    public Mensaje(Cliente cliente, double monto, String descripcion) {
        this.cliente = cliente;
        this.monto = monto;
        this.descripcion = descripcion;
    }
    //Constructor para enviar a venta
    public Mensaje(Pago pago, String descripcion) {
        this.pago= pago;
        this.descripcion = descripcion;
    }
    //constructor para enviar a inventario
    public Mensaje(CarritoCompra carrito, String descripcion) {
        this.carrito = carrito;
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
    //por si acaso se necesita
    public CarritoCompra getCarrito() {
        return carrito;
    }
}
