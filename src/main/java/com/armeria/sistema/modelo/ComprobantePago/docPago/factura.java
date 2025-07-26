package com.armeria.sistema.modelo.ComprobantePago.docPago;

import java.time.LocalDate;

public abstract class factura {
    protected String numeroComprobate;
    protected String nombreVenderdor;
    protected String rucEmpresa;
    protected String direccionEmpresa;
    protected String nombreCliente;
    protected String rucCliente;
    protected LocalDate fechaEmision;
    protected double montoTotal;

    public factura() {
        // Constructor por defecto
    }
    public factura(String numeroComprobate, String nombreVenderdor, String rucEmpresa, String direccionEmpresa, String nombreCliente, String rucCliente, LocalDate fechaEmision, double montoTotal) {
        this.numeroComprobate = numeroComprobate;
        this.nombreVenderdor = nombreVenderdor;
        this.rucEmpresa = rucEmpresa;
        this.direccionEmpresa = direccionEmpresa;
        this.nombreCliente = nombreCliente;
        this.rucCliente = rucCliente;
        this.fechaEmision = fechaEmision;
        this.montoTotal = montoTotal;
    }

    public void generarFactura() {
        //
    }
    
}
