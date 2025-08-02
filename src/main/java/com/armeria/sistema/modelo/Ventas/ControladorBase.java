package com.armeria.sistema.modelo.Ventas;

import com.armeria.sistema.modelo.gestorInventario.TipoProducto;

import java.util.List;

public abstract class ControladorBase implements Controlador {
    protected Controlador siguiente;

    @Override
    public void setSiguiente(Controlador siguiente) {
        this.siguiente = siguiente;
    }

    // Metodos abstractos que deben ser implementados por las subclases
    public abstract boolean validarRegistro(Cliente cliente, ItemVenta itemVenta, List<ItemVenta> itemVentaList);

    // Metodo para registrar un producto, verifica si el cliente puede comprarlo
    public boolean esCompatibleConArmaRegistrada(Producto producto){
        System.out.println("Verificando compatibilidad del producto " + producto.getNombre() + " con armas registradas.");
        return false; // Por defecto, se asume que es compatible
    }

    public boolean excedeLimitePermitido(Cliente cliente, ItemVenta itemVenta, List<ItemVenta> itemVentaList) {
        System.out.println("Verificando si el cliente " + cliente.getNombre() + " excede el límite permitido para el producto " + itemVenta.getProducto().getNombre());
        return false; // Por defecto, se asume que no excede el límite
    }

    public int revisarAcumulado (Producto producto, List<ItemVenta> itemVentaList){
        int acumulado = 0;

        for (ItemVenta item : itemVentaList) {
            if (item.getProducto().getTipo().equals(producto.getTipo())) {
                acumulado += item.getCantidad();
            }
        }
        System.out.println("Cantidad acumulada de productos tipo " + producto.getTipo() + ": " + acumulado);
        return acumulado;
    }

    //Metodo para validar el siguiente controlador en la cadena
    protected boolean validarSiguiente(Cliente cliente, ItemVenta itemVenta, List<ItemVenta> itemVentaList) {
        if (siguiente == null) return true;
        return siguiente.registrarProducto(cliente, itemVenta, itemVentaList);
    }
}
