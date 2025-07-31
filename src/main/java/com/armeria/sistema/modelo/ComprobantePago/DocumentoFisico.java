package com.armeria.sistema.modelo.ComprobantePago;
import java.time.LocalDate;

// import com.armeria.sistema.modelo.ComprobantePago.docTrasladoArma;

public class DocumentoFisico extends DocumentoTrasladoBienesArmas {
    private String oficina;

    public DocumentoFisico() {
        // Constructor por defecto
    }

    public DocumentoFisico(String nombreVendedor, String rucEmpresa, String direccionEmpresa, String nombreCliente, String dniCliente, String direccionCliente, LocalDate fechaEmision, String descripcionBienes, double montoTotal, String arma, String oficina) {
        super(nombreVendedor, arma, descripcionBienes, direccionCliente, rucEmpresa, direccionEmpresa, nombreCliente, dniCliente, fechaEmision, montoTotal);
        this.oficina = oficina;
    }
    public String getOficina() {
        return oficina;
    }
    public void setOficina(String oficina) {
        this.oficina = oficina;
    }


    @Override
    public void generarDocumento() {

        // Implementación para generar el documento de traslado de arma físico
        System.out.println("Generando documento físico de traslado de arma...");
        System.out.println("Nombre del vendedor: " + nombreVendedor);
        System.out.println("RUC de la empresa: " + rucEmpresa);
        System.out.println("Dirección de la empresa: " + direccionEmpresa);
        System.out.println("Nombre del cliente: " + nombreCliente);
        System.out.println("DNI del cliente: " + dniCliente);
        System.out.println("Fecha de emisión: " + fechaEmision);
        System.out.println("Monto total: " + montoTotal);
        System.out.println("Descripción de bienes: " + descripcionBienes);
        System.out.println("Arma: " + arma);
        System.out.println("Oficina: " + oficina);
        System.out.println("Documento físico de traslado de arma generado exitosamente.");
    }
    
}
