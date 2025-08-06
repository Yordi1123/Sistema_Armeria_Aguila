package com.armeria.sistema.modelo.Ventas;

import com.armeria.sistema.modelo.Pago.Pago;

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
        double subTotal = pago.getMonto() * (100/118);
        double igv = pago.getMonto() - subTotal;

        System.out.println("""
                ╔══════════════════════════════════════════════════════════════╗
                ║                  COMPROBANTE DE PAGO                         ║
                ╚══════════════════════════════════════════════════════════════╝
                                    Armería El Águila S.R.L
                                      RUC: 20445412628
                ───────────────────────────────────────────────────────────────
                """);

        System.out.printf("Cliente        : %s %s%n", pago.getCliente().getNombre(), pago.getCliente().getApellido());
        System.out.printf("Licencia       : %s%n", pago.getCliente().isTieneLicencia() ? pago.getCliente().getTipoLicencia() : "No tiene");
        System.out.printf("Fecha          : %s%n",
                pago.getFechaPago().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")));

        System.out.println("""
                ───────────────────────────────────────────────────────────────
                Producto                  Cant.   P. Unit (S/.)     Subtotal
                ───────────────────────────────────────────────────────────────""");

        double total = 0.0;
        for (ItemVenta item : carritoCompra.getItemVentaList()) {
            double subtotal = item.getCantidad() * item.getProducto().getPrecioUnitario();
            total += subtotal;
            System.out.printf(Locale.US, "%-25s %6d     %10.2f     %10.2f%n",
                    item.getProducto().getNombre(),
                    item.getCantidad(),
                    item.getProducto().getPrecioUnitario(),
                    subtotal);
        }

        System.out.println("───────────────────────────────────────────────────────────────");
        System.out.printf(Locale.US, "%-48s S/ %10.2f%n", "Subtotal:", subTotal);
        System.out.printf(Locale.US, "%-48s S/ %10.2f%n", "IGV (18%):", igv);
        System.out.printf(Locale.US, "%-48s S/ %10.2f%n", "TOTAL PAGADO:", pago.getMonto());
        System.out.printf(Locale.US, "%-40s %21s%n", "Método de Pago:", pago.getMetodoPago());
        System.out.println("═══════════════════════════════════════════════════════════════\n");
    }


    // Métodos Getter y Setter
    public Pago getPago() {
        return pago;
    }

    public void setPago(Pago pago) {
        this.pago = pago;
    }


}
