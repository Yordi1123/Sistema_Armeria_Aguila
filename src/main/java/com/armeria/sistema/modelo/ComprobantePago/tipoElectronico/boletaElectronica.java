package com.armeria.sistema.modelo.ComprobantePago.tipoElectronico;

import java.time.LocalDate;

import com.armeria.sistema.modelo.ComprobantePago.docPago.boleta;
public class boletaElectronica extends boleta {
    
    private String codigoSeguridad;
    private String codigoQR;
    private String codSunat;
    public boletaElectronica() {
        // Constructor por defecto
    }
    

    public boletaElectronica(String numeroComprobante, String nombreVendedor, String rucEmpresa, String direccionEmpresa, String nombreCliente, String direccionCliente, String dniCliente, LocalDate fechaEmision, double montoTotal, String oficina, String codigoSeguridad, String codigoQR, String codSunat) {
        super(numeroComprobante, rucEmpresa, direccionEmpresa, direccionCliente, nombreVendedor, nombreCliente, dniCliente, fechaEmision, montoTotal);
        this.codigoQR = codigoQR;
        this.codSunat = codSunat;
    }

    public String getCodigoSeguridad() {
        return codigoSeguridad;
    }
    public void setCodigoSeguridad(String codigoSeguridad) {
        this.codigoSeguridad = codigoSeguridad;
    }
    public String getCodigoQR() {
        return codigoQR;
    }
    public void setCodigoQR(String codigoQR) {
        this.codigoQR = codigoQR;
    }
    public String getCodSunat() {
        return codSunat;
    }
    public void setCodSunat(String codSunat) {
        this.codSunat = codSunat;
    }   

    @Override
    public String toString() {
        return "Boleta Electrónica{" +
                "Número de comprobante='" + numeroComprobante + '\'' +
                ", Vendedor='" + nombreVendedor + '\'' +
                ", Cliente='" + nombreCliente + '\'' +
                ", Tipo de documento='" + dniCliente + '\'' +
                ", Fecha de emisión=" + fechaEmision +
                ", Monto total=" + montoTotal +
                ", Código de seguridad='" + codigoSeguridad + '\'' +
                ", Código QR='" + codigoQR + '\'' +
                ", Código SUNAT='" + codSunat + '\'' +
                '}';
    }

    // public void generarBoletaElectronica() {
    //}   
}
