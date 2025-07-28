// Estrategia de venta para escopetas
package com.armeria.sistema.modelo.Ventas;

import java.util.List;

public class VentaArma implements EstrategiaVenta{


    @Override
    public void procesarVenta(List<ItemVenta> itemList, Cliente cliente) {

        // Verificar si el cliente tiene licencia para comprar armas
        if (clienteTieneLicencia(cliente)){

            // creando el carrito de compra del cliente
            CarritoCompra carritoCompra = new CarritoCompra(cliente);

            // Agregar los items de venta al carrito
            carritoCompra.procesarProductos();

            // Calcular el total de la venta

            // Procesar pago (metodo para efectuar el pago)

            // Generar comprobante de pago

        } else {
            // Si el cliente no tiene licencia, mostrar un mensaje de error
            System.out.println("El cliente " + cliente.getNombre() + " no tiene licencia para comprar armas.");
        }
    }

    @Override
    public double calcularTotalVenta(List<ItemVenta> itemList) {
        return 0;
    }

    @Override
    public boolean validadVenta(Cliente cliente, ItemVenta item) {
        return false;
    }

    public boolean clienteTieneLicencia(Cliente cliente) {
        // Lógica para verificar si el cliente tiene licencia para comprar armas
        return cliente.isTieneLicencia();
    }
}
