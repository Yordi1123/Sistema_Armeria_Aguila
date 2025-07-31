package com.armeria.sistema.modelo.ComprobantePago;

import java.time.LocalDate;

public class FacturaElectronica extends Factura {
    private String codigoSunac;

    public FacturaElectronica(String numeroComprobante, String rucEmpresa, String nombreVendedor,
            String direccionEmpresa, String rucCliente, String nombreCliente,
            LocalDate fechaEmision, double montoTotal, String codigoSunac) {
        super(numeroComprobante, nombreVendedor, rucEmpresa, direccionEmpresa,
                nombreCliente, rucCliente, fechaEmision, montoTotal);
        this.codigoSunac = codigoSunac;
    }

    @Override
    public void generarFactura() {
        System.out.println("\n========== FACTURA ELECTRÓNICA ==========");
        System.out.printf(" N° Comprobante     : %s%n", numeroComprobante);
        System.out.printf(" Código SUNAC       : %s%n", codigoSunac);
        System.out.println("------------------------------------------");
        System.out.printf(" Vendedor           : %s%n", nombreVendedor);
        System.out.printf(" RUC Empresa        : %s%n", rucEmpresa);
        System.out.printf(" Dirección Empresa  : %s%n", direccionEmpresa);
        System.out.println("------------------------------------------");
        System.out.printf(" Cliente            : %s%n", nombreCliente);
        System.out.printf(" RUC Cliente        : %s%n", rucCliente);
        System.out.printf(" Fecha Emisión      : %s%n", fechaEmision);
        System.out.printf(" Total              : S/ %.2f%n", montoTotal);
        System.out.println("==========================================\n");
    }

}
