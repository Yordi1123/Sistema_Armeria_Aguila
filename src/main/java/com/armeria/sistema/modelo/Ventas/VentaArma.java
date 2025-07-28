// Estrategia de venta de armas
package com.armeria.sistema.modelo.Ventas;

import com.armeria.sistema.modelo.gestorInventario.TipoProducto;

import java.util.List;

public class VentaArma implements EstrategiaVenta {


    @Override
    public void procesarVenta(Cliente cliente) {

        // Verificar si el cliente es válido y tiene licencia
        if (!esClienteValidoYAutorizado(cliente)) {
            return;
        }

        System.out.println("Licencia verificada. Iniciando proceso de venta para " + cliente.getNombre());

        // Procesar la compra del cliente
        CarritoCompra carritoCompra = new CarritoCompra(cliente);
        carritoCompra.procesarProductos();

        if (carritoCompra.getItemVentaList().isEmpty()) {
            System.out.println("No se agregó ningún producto al carrito. Venta cancelada.");
            return;
        }

        double montoTotal = calcularTotalVenta(carritoCompra);
        if (montoTotal <= 0) {
            System.out.println("El monto total de la venta es inválido. Venta cancelada.");
            return;
        }

        System.out.printf("Monto total a pagar: S/. %.2f%n", montoTotal);

        // Procesar el pago del cliente
        Pago pagoCliente = new Pago(cliente, montoTotal);
        if (!pagoCliente.procesarPago()) {
            System.out.println("El pago no se pudo procesar. Venta cancelada.");
            return;
        }

        // Actualizar el inventario y generar comprobante
        Inventario.actualizarStockGeneral(carritoCompra);
        pagoCliente.generarComprobante(carritoCompra);

        System.out.println("Venta procesada exitosamente. Gracias por su compra, " + cliente.getNombre() + ".");
    }

    // Metodo para calcular el total de la venta
    // Recorre la lista de items de venta y suma los subtotales de cada item
    // Retorna el total de la venta
    @Override
    public double calcularTotalVenta(CarritoCompra carrito) {

        double total = 0;
        for (ItemVenta item : carrito.getItemVentaList()) {
            total += item.calcularSubtotal();
        }
        return total;
    }

    // Metodo para validar la venta
    @Override
    public boolean validadVenta(boolean isValido) {
        if (isValido) {
            System.out.println("Venta procesada correctamente.");
            return true;

        } else {
            System.out.println("La venta no se pudo procesar.");
            return false;
        }
    }

    private boolean esClienteValidoYAutorizado(Cliente cliente) {
        if (cliente == null) {
            System.out.println("Error: Cliente no válido.");
            return false;
        }

        if (!cliente.isTieneLicencia()) {
            System.out.println("El cliente " + cliente.getNombre() + " no tiene licencia para comprar armas.");
            return false;
        }

        return true;
    }
}
