package com.armeria.sistema.modelo.AbstractFactori.tipoFisico;
import com.armeria.sistema.modelo.AbstractFactori.docPago.boleta;
import java.time.LocalDate;

public class BoletaFisica extends boleta {

    private String oficina;

    public BoletaFisica() {
        // Constructor por defecto
    }
    public BoletaFisica(String numeroComprobante, String nombreVendedor, String rucEmpresa, String direccionEmpresa, String nombreCliente, String direccionCliente, String dniCliente, LocalDate fechaEmision, double montoTotal, String oficina) {
        super(numeroComprobante, rucEmpresa, direccionEmpresa, direccionCliente, nombreVendedor, nombreCliente, dniCliente, fechaEmision, montoTotal);
        this.oficina = oficina;
    }

    public String getOfcina() {
        return oficina;
    }

    public void setOfcina(String oficina) {
        this.oficina = oficina;
    }

    @Override
    public void generarBoleta() {
        System.out.println("Generando factura física...");
        System.out.println("Número de comprobante: " + numeroComprobante);
        System.out.println("Nombre del vendedor: " + nombreVendedor);
        System.out.println("RUC de la empresa: " + rucEmpresa);
        System.out.println("Dirección de la empresa: " + direccionEmpresa);
        System.out.println("Nombre del cliente: " + nombreCliente);
        System.out.println("RUC del cliente: " + dniCliente);
        System.out.println("Fecha de emisión: " + fechaEmision);
        System.out.println("Monto total: " + montoTotal);
        System.out.println("Oficina: " + oficina);
    }
}
