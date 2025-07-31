package com.armeria.sistema.modelo.ComprobantePago;

import java.time.LocalDate;

public abstract class Boleta {
    protected String numeroComprobante;
    protected String nombreVendedor;
    protected String dniVendedor;
    protected String direccionVendedor;
    protected String nombreCliente;
    protected String dniCliente;
    protected LocalDate fechaEmision;
    protected double montoTotal;

    public Boleta(String numeroComprobante, String dniVendedor,
                  String nombreVendedor, String direccionVendedor,
                  String dniCliente, String nombreCliente,
                  LocalDate fechaEmision, double montoTotal) {
        this.numeroComprobante = numeroComprobante;
        this.dniVendedor = dniVendedor;
        this.nombreVendedor = nombreVendedor;
        this.direccionVendedor = direccionVendedor;
        this.dniCliente = dniCliente;
        this.nombreCliente = nombreCliente;
        this.fechaEmision = fechaEmision;
        this.montoTotal = montoTotal;
    }

    public abstract void generarBoleta();
}
