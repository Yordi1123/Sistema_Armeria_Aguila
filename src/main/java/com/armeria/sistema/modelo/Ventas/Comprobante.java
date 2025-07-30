package com.armeria.sistema.modelo.Ventas;

import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Comprobante {

    private Pago pago;
    private CarritoCompra carritoCompra;

    public Comprobante(Pago pago, CarritoCompra carritoCompra) {
        this.pago = pago;
        this.carritoCompra = carritoCompra;
    }

    public void generarComprobante() {
        System.out.println("\n\n===================== COMPROBANTE DE PAGO =====================");
        System.out.println("                        ARMERÍA S.A.C.");
        System.out.println("                      RUC: 12345678901");
        System.out.println("---------------------------------------------------------------");
        System.out.println("Cliente: " + pago.getCliente().getNombre() + " " + pago.getCliente().getApellido());
        System.out.println("Fecha: " + pago.getFechaPago().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")));
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
        System.out.printf("%-47s %12s%n", "Método de Pago:", pago.getMetodoPago());
        System.out.println("===============================================================\n\n");

    }

    // Métodos Getter y Setter
    public Pago getPago() {
        return pago;
    }

    public void setPago(Pago pago) {
        this.pago = pago;
    }

    public CarritoCompra getCarritoCompra() {
        return carritoCompra;
    }

    public void setCarritoCompra(CarritoCompra carritoCompra) {
        this.carritoCompra = carritoCompra;
    }
}
