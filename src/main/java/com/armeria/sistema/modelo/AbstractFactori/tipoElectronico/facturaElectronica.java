package com.armeria.sistema.modelo.AbstractFactori.tipoElectronico;
import java.time.LocalDate;
import com.armeria.sistema.modelo.AbstractFactori.docPago.factura;

public class facturaElectronica extends factura{
    private String codigoQR;
    private String firmaDigital;
    private String codSunat;

    public facturaElectronica() {
        // Constructor por defecto
    }

    public facturaElectronica(String numeroComprobate, String nombreVenderdor, String rucEmpresa, String direccionEmpresa, String nombreCliente, String rucCliente, LocalDate fechaEmision, double montoTotal, String codigoQR, String firmaDigital, String codSunat) {
        super(numeroComprobate, nombreVenderdor, rucEmpresa, direccionEmpresa, nombreCliente, rucCliente, fechaEmision, montoTotal);
        this.codigoQR = codigoQR;
        this.firmaDigital = firmaDigital;
        this.codSunat = codSunat;
    }

    // public String getCodigoQR() {
    //     return codigoQR;
    // }
    // public void setCodigoQR(String codigoQR) {
    //     this.codigoQR = codigoQR;
    // }
    // public String getFirmaDigital() {
    //     return firmaDigital;
    // }
    // public void setFirmaDigital(String firmaDigital) {
    //     this.firmaDigital = firmaDigital;
    // }
    // public String getCodSunat() {
    //     return codSunat;
    // }
    // public void setCodSunat(String codSunat) {
    //     this.codSunat = codSunat;
    // }
    
    public void generarFacturaElectronica() {
        System.out.println("Generando factura electrónica...");
        System.out.println("Número de comprobante: " + numeroComprobate);
        System.out.println("Vendedor: " + nombreVenderdor);
        System.out.println("Empresa: " + rucEmpresa + " | Dirección: " + direccionEmpresa);
        System.out.println("Cliente: " + nombreCliente + " | RUC: " + rucCliente);
        System.out.println("Fecha de emisión: " + fechaEmision);
        System.out.println("Monto total: S/ " + String.format("%.2f", montoTotal));
        System.out.println("Código QR: " + codigoQR);
        System.out.println("Firma digital: " + firmaDigital);
        System.out.println("Código SUNAT: " + codSunat);
        System.out.println("Factura electrónica generada exitosamente.");
        }
    
}
