// Estrategia de venta de armas
package com.armeria.sistema.modelo.Ventas;

import com.armeria.sistema.modelo.gestorInventario.TipoProducto;

import java.util.List;

public class VentaArma implements EstrategiaVenta{


    @Override
    public void procesarVenta( Cliente cliente) {

        // Verificar si el cliente tiene licencia para comprar armas
        if (clienteTieneLicencia(cliente)){

            // creando el carrito de compra del cliente
            CarritoCompra carritoCompra = new CarritoCompra(cliente);

            // Agregar los items de venta al carrito
            carritoCompra.procesarProductos();

            // Calcular el total de la venta
            double montoTotal = calcularTotalVenta(carritoCompra);

            // Procesar pago (metodo para efectuar el pago)
            Pago pagoCliente = new Pago(cliente, montoTotal);
            pagoCliente.procesarPago();


            // Actualizar el inventario de armas
            Inventario.actualizarStockGeneral(carritoCompra);

            // Generar comprobante de pago
            pagoCliente.generarComprobante(carritoCompra);


        } else {
            // Si el cliente no tiene licencia, mostrar un mensaje de error
            System.out.println("El cliente " + cliente.getNombre() + " no tiene licencia para comprar armas.");
        }
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


        } else {
            System.out.println("La venta no se pudo procesar.");
        }
    }

    public boolean clienteTieneLicencia(Cliente cliente) {
        // Lógica para verificar si el cliente tiene licencia para comprar armas
        return cliente.isTieneLicencia();
    }
}
