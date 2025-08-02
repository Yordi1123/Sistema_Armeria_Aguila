package com.armeria.sistema.modelo.Ventas;
import java.util.List;

public interface Controlador {
    void setSiguiente(Controlador siguiente);
    boolean registrarProducto(Cliente cliente, ItemVenta itemVenta, List<ItemVenta> itemVentaList);
}
