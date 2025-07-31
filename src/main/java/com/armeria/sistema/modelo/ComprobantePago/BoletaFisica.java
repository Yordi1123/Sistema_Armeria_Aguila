package com.armeria.sistema.modelo.ComprobantePago;

import java.time.LocalDate;

public class BoletaFisica extends Boleta {
    private String oficina;

    public BoletaFisica(String numeroComprobante, String nombreVendedor, String dniVendedor, String direccionVendedor,
            String nombreCliente, String dniCliente, LocalDate fechaEmision, double montoTotal, String oficina) {
        super(numeroComprobante, dniVendedor, nombreVendedor, direccionVendedor, dniCliente, nombreCliente,
                fechaEmision, montoTotal);
        this.oficina = oficina;
    }

    public String getOficina() {
        return oficina;
    }

    public void setOficina(String oficina) {
        this.oficina = oficina;
    }

    @Override
    public void generarBoleta() {
        System.out.println("\n=========== BOLETA FÍSICA ==============");
        System.out.printf(" N° Comprobante  : %s%n", numeroComprobante);
        System.out.printf(" Fecha Emisión   : %s%n", fechaEmision);
        System.out.println("----------------------------------------");
        System.out.printf(" Vendedor        : %s%n", nombreVendedor);
        System.out.printf(" Cliente         : %s%n", nombreCliente);
        System.out.printf(" DNI Cliente     : %s%n", dniCliente);
        System.out.println("----------------------------------------");
        System.out.printf(" Monto Total     : S/ %.2f%n", montoTotal);
        System.out.printf(" Oficina Emisión : %s%n", oficina);
        System.out.println("========================================\n");
    }

}
