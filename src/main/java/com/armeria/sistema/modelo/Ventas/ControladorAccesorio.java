package com.armeria.sistema.modelo.Ventas;

import com.armeria.sistema.modelo.gestorInventario.TipoProducto;

import java.util.List;

public class ControladorAccesorio extends ControladorBase{

    // Registrar producto tipo arma, verifica si el cliente tiene licencia
    @Override
    public boolean registrarProducto(Cliente cliente, ItemVenta itemventa, List<ItemVenta> itemVentaList) {
        if (itemventa.getProducto().getTipo().equals(TipoProducto.ACCESORIO) ){
            System.out.println("Procesando producto tipo accesorio...");
            return validarRegistro(cliente, itemventa, itemVentaList);
        } else {
            System.out.println("El producto no un accesorio.");
        }
        return validarSiguiente(cliente, itemventa, itemVentaList);
    }

    // Metodo que verifica que no se necesita licencia para accesorios
    @Override
    public boolean validarRegistro(Cliente cliente, ItemVenta itemventa, List<ItemVenta> itemVentaList) {

        System.out.println("Cliente " + cliente.getNombre() + " " + cliente.getApellido() + " puede comprar accesorios sin licencia.");
        return true;
    }
}
