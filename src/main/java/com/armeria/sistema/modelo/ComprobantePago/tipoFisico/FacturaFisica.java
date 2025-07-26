package com.armeria.sistema.modelo.AbstractFactory.tipoFisico;
import com.armeria.sistema.modelo.AbstractFactory.docPago.factura;
import java.time.LocalDate;

public class FacturaFisica  extends factura {
    private String oficina;

    public FacturaFisica() {

    }
    public FacturaFisica(String numeroComprobate, String nombreVenderdor, String rucEmpresa, String direccionEmpresa, String nombreCliente, String rucCliente, LocalDate fechaEmision, double montoTotal, String oficina) {
        super(numeroComprobate, nombreVenderdor, rucEmpresa, direccionEmpresa, nombreCliente, rucCliente, fechaEmision, montoTotal);
        this.oficina = oficina;
    }
    
    public String getOficina() {
        return oficina;
    }

    public void setOficina(String oficina) {
        this.oficina = oficina;
    }

    @Override
    public void generarFactura(){
        System.out.println("Generando factura física...");
        System.out.println("Número de comprobante: " + numeroComprobate);
        System.out.println("Nombre del vendedor: " + nombreVenderdor);
        System.out.println("RUC de la empresa: " + rucEmpresa);
        System.out.println("Dirección de la empresa: " + direccionEmpresa);
        System.out.println("Nombre del cliente: " + nombreCliente);
        System.out.println("RUC del cliente: " + rucCliente);
        System.out.println("Fecha de emisión: " + fechaEmision);
        System.out.println("Monto total: " + montoTotal);
        System.out.println("Oficina: " + oficina);
    }
}
    
