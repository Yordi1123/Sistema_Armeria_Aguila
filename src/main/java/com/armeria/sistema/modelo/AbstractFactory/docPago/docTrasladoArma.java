package com.armeria.sistema.modelo.AbstractFactory.docPago;

import java.time.LocalDate;

public abstract class docTrasladoArma {
    protected String nombreVendedor;
    protected String rucEmpresa;
    protected String direccionEmpresa;
    protected String nombreCliente;
    protected String dniCliente;
    protected String direccionCliente;
    protected LocalDate fechaEmision;
    protected String descripcionBienes;
    protected double montoTotal;
    protected String arma;

    public docTrasladoArma() {
        // Constructor por defecto
    }

    public docTrasladoArma(String nombreVendedor,String arma, String descripcionBienes, String direccionCliente, String rucEmpresa, String direccionEmpresa, String nombreCliente, String dniCliente, LocalDate fechaEmision, double montoTotal) {
        this.nombreVendedor = nombreVendedor;
        this.rucEmpresa = rucEmpresa;
        this.direccionEmpresa = direccionEmpresa;
        this.nombreCliente = nombreCliente;
        this.dniCliente = dniCliente;
        this.direccionCliente = direccionCliente;
        this.descripcionBienes = descripcionBienes;
        this.arma = arma;
        this.fechaEmision = fechaEmision;
        this.montoTotal = montoTotal;
    }

    public abstract void generarDocumento();
    
        // Lógica para generar el documento de traslado de arma

    
}
