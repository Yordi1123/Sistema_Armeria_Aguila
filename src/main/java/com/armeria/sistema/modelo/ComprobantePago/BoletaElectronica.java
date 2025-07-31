package com.armeria.sistema.modelo.ComprobantePago;

import java.time.LocalDate;

public class BoletaElectronica extends Boleta {
    private String codigoSeguridad;
    private String codigoQR;
    private String codSunat;

    public BoletaElectronica(String numeroComprobante, String nombreVendedor, String dniVendedor,
            String direccionVendedor,
            String nombreCliente, String dniCliente, LocalDate fechaEmision, double montoTotal,
            String codigoSeguridad, String codigoQR, String codSunat) {
        super(numeroComprobante, dniVendedor, nombreVendedor, direccionVendedor, dniCliente, nombreCliente,
                fechaEmision, montoTotal);
        this.codigoSeguridad = codigoSeguridad;
        this.codigoQR = codigoQR;
        this.codSunat = codSunat;
    }

@Override
public void generarBoleta() {
    System.out.println("\n========== BOLETA ELECTRÓNICA ==========");
    System.out.printf(" N° Comprobante     : %s%n", numeroComprobante);
    System.out.printf(" Fecha Emisión      : %s%n", fechaEmision);
    System.out.println("----------------------------------------");
    System.out.printf(" Vendedor           : %s%n", nombreVendedor);
    System.out.printf(" Cliente            : %s%n", nombreCliente);
    System.out.printf(" DNI Cliente        : %s%n", dniCliente);
    System.out.println("----------------------------------------");
    System.out.printf(" Monto Total        : S/ %.2f%n", montoTotal);
    System.out.println("----------------------------------------");
    System.out.printf(" Código Seguridad   : %s%n", codigoSeguridad);
    System.out.printf(" Código QR          : %s%n", codigoQR);
    System.out.printf(" Código SUNAT       : %s%n", codSunat);
    System.out.println("========================================\n");
}


}
