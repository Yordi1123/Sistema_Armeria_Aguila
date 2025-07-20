package com.armeria.sistema.modelo.gestorInventario;
import java.util.ArrayList ;
import java.util.List ;
public abstract class GestorProducto {
    protected List<ProductoArmeria> inventario;
    public GestorProducto () {
        this . inventario = new ArrayList<>();
    }
    public void registrarProducto (ProductoArmeria producto) {
        if (producto != null ) {
            inventario. add (producto);
            System. out . println ("Producto registrado: " + producto. nombre + " (" + producto. tipo + ")");
        }
    }
    public abstract void buscarPorMarca (String marca);
    public abstract boolean eliminarPorNombre (String nombre);
    public abstract double calcularValorTotal ();
    public abstract void mostrarInventario ();
}

