package com.armeria.sistema.modelo.Ventas;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Pago {
    private Cliente cliente;
    private MetodoPagoEnum metodoPago; // Ejemplo: "Tarjeta de Crédito", "Efectivo", etc.
    private double monto;
    private LocalDateTime fechaPago;

    public Pago(Cliente cliente, double monto) {
        this.cliente = cliente;
        this.monto = monto;
    }
    // Metodo para procesar el pago
    public boolean procesarPago() {

        // Lógica para procesar el pago
        seleccionarMedioPago();
        System.out.println("Procesando pago de " + monto + " con método " + metodoPago);

        // Simulación de procesamiento de pago
        if (monto > 0) {
            System.out.println("Pago procesado exitosamente.");
            setFechaPago(LocalDateTime.now());
            return true;
        } else {
            System.out.println("Error: Monto de pago inválido.");}
            return false;
    }

    // Metodo para generar un comprobante de pago (esta se extiende al modulo Comprobante de Pago)
    public void generarComprobante(CarritoCompra carritoCompra) {
        System.out.println("\n\n===================== COMPROBANTE DE PAGO =====================");
        System.out.println("                        ARMERÍA S.A.C.");
        System.out.println("                      RUC: 12345678901");
        System.out.println("---------------------------------------------------------------");
        System.out.println("Cliente: " + cliente.getNombre() + " " + cliente.getApellido());
        System.out.println("Fecha: " + fechaPago.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")));
        System.out.println("---------------------------------------------------------------");
        System.out.printf("%-25s %8s %12s %12s%n", "Producto", "Cant.", "P. Unit (S/.)", "Subtotal");
        System.out.println("---------------------------------------------------------------");

        double total = 0.0;
        for (ItemVenta item : carritoCompra.getItemVentaList()) {
            String nombre = item.getProducto().getNombre();
            int cantidad = item.getCantidad();
            double precioUnitario = item.getProducto().getPrecioUnitario();
            double subtotal = cantidad * precioUnitario;
            total += subtotal;

            System.out.printf(Locale.US, "%-25s %8d %12.2f %12.2f%n", nombre, cantidad, precioUnitario, subtotal);
        }

        System.out.println("---------------------------------------------------------------");
        System.out.printf(Locale.US, "%-47s %12.2f%n", "TOTAL A PAGAR (S/.):", total);
        System.out.printf("%-47s %12s%n", "Método de Pago:", metodoPago);
        System.out.println("===============================================================\n\n");

    }

    // Método para seleccionar el método de pago
    public void seleccionarMedioPago() {
        System.out.println("Selecione medio de pago:");
        System.out.println("1. Tarjeta de Credito");
        System.out.println("2. Tarjeta de Debito");
        System.out.println("3. Efectivo");
        System.out.println("4. Transferencia Bancaria");
        System.out.println("5. Yape");
        System.out.println("6. Blimp");
        System.out.println("==============================================");
        int metodoSelect = Integer.parseInt(System.console().readLine());

        switch (metodoSelect) {

            case 1:
                this.metodoPago = MetodoPagoEnum.TARJETA_CREDITO;
                break;
            case 2:
                this.metodoPago = MetodoPagoEnum.TARJETA_DEBITO;
                break;
            case 3:
                this.metodoPago = MetodoPagoEnum.EFECTIVO;
                break;
            case 4:
                this.metodoPago = MetodoPagoEnum.TRANSFERENCIA_BANCARIA;
                break;
            case 5:
                this.metodoPago = MetodoPagoEnum.YAPE;
                break;
            case 6:
                this.metodoPago = MetodoPagoEnum.BLIMP;
                break;

            default:
                System.out.println("Método de pago no válido. Seleccione nuevamente.");
                break;
        }
    }

    // Métodos Getter y Setter
    public MetodoPagoEnum getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(MetodoPagoEnum metodoPago) {
        this.metodoPago = metodoPago;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public LocalDateTime getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(LocalDateTime fechaPago) {
        this.fechaPago = fechaPago;
    }

    // Enum para los métodos de pago
    public enum MetodoPagoEnum {
        TARJETA_CREDITO,
        TARJETA_DEBITO,
        EFECTIVO,
        TRANSFERENCIA_BANCARIA,
        YAPE,
        BLIMP;
    }
}
