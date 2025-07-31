package com.armeria.sistema.modelo.ComprobantePago;

import java.time.LocalDate;

public abstract class Factura {
    protected String numeroComprobante;
    protected String nombreVendedor;
    protected String rucEmpresa;
    protected String direccionEmpresa;
    protected String nombreCliente;
    protected String rucCliente;
    protected LocalDate fechaEmision;
    protected double montoTotal;

    public Factura() {
        // Constructor por defecto
    }

    public Factura(String numeroComprobante, String nombreVendedor, String rucEmpresa, String direccionEmpresa,
                   String nombreCliente, String rucCliente, LocalDate fechaEmision, double montoTotal) {
        this.numeroComprobante = numeroComprobante;
        this.nombreVendedor = nombreVendedor;
        this.rucEmpresa = rucEmpresa;
        this.direccionEmpresa = direccionEmpresa;
        this.nombreCliente = nombreCliente;
        this.rucCliente = rucCliente;
        this.fechaEmision = fechaEmision;
        this.montoTotal = montoTotal;
    }

    public abstract void generarFactura();
}
