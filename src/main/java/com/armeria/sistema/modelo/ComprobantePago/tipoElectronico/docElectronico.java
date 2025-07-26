package com.armeria.sistema.modelo.ComprobantePago.tipoElectronico;
import java.time.LocalDate;

import com.armeria.sistema.modelo.ComprobantePago.docPago.docTrasladoArma;

public class docElectronico extends docTrasladoArma {
    private String codSunat;
    private String Sucamet;

    public docElectronico() {
        // Constructor por defecto
    }
    public docElectronico(String nombreVendedor, String rucEmpresa, String direccionEmpresa, String nombreCliente, String dniCliente, String direccionCliente, LocalDate fechaEmision, String descripcionBienes, double montoTotal, String arma, String codSunat, String Sucamet) {
        super(nombreVendedor, arma, descripcionBienes, direccionCliente, rucEmpresa, direccionEmpresa, nombreCliente, dniCliente, fechaEmision, montoTotal);
        this.codSunat = codSunat;
        this.Sucamet = Sucamet;
    }

    @Override
    public void generarDocumento() {
   
        System.out.println("Generando documento electrónico de traslado de arma...");
        System.out.println("Nombre del vendedor: " + nombreVendedor);
        System.out.println("RUC de la empresa: " + rucEmpresa); 
        System.out.println("Dirección de la empresa: " + direccionEmpresa);
        System.out.println("Nombre del cliente: " + nombreCliente);
        System.out.println("DNI del cliente: " + dniCliente);
        System.out.println("Fecha de emisión: " + fechaEmision);
        System.out.println("Descripción de bienes: " + descripcionBienes);
        System.out.println("Arma: " + arma);
        System.out.println("Monto total: " + montoTotal);
        System.out.println("Código SUNAT: " + codSunat);
        System.out.println("Sucamet: " + Sucamet);
    }
}   
