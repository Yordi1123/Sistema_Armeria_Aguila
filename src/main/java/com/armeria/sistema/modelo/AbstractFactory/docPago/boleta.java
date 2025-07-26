package com.armeria.sistema.modelo.AbstractFactory.docPago;

import java.time.LocalDate;

public abstract class boleta {
    protected String numeroComprobante;
    protected String nombreVendedor;
    protected String rucEmpresa;
    protected String direccionEmpresa;
    protected String nombreCliente;
    protected String direccionCliente;
    protected String dniCliente; 
    protected LocalDate fechaEmision;
    protected double montoTotal;

    public boleta(){
        // Constructor por defecto
    }

    public boleta(String numeroComprobante,String rucEmpresa, String direccionEmpresa, String direccionCliente, String nombreVendedor, String nombreCliente, String tipoDocumento, LocalDate fechaEmision, double montoTotal) {
        this.numeroComprobante = numeroComprobante;
        this.nombreVendedor = nombreVendedor;
        this.nombreCliente = nombreCliente;
        this.dniCliente = tipoDocumento;
        this.fechaEmision = fechaEmision;
        this.montoTotal = montoTotal;
        this.direccionCliente = direccionCliente;
        this.rucEmpresa = rucEmpresa;
        this.direccionEmpresa = direccionEmpresa;

    }

    public void generarBoleta(){
        //

    }
}
