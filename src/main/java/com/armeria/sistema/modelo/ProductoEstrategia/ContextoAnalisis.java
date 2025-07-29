package com.armeria.sistema.modelo.ProductoEstrategia;
import java.util.List;

public class ContextoAnalisis {
    private EstrategiaAnalisis estrategia;

    public ContextoAnalisis(EstrategiaAnalisis estrategia) {
        this.estrategia = estrategia;
    }

    public void setEstrategia(EstrategiaAnalisis estrategia) {
        this.estrategia = estrategia;
    }

    public void analizarProductos(List<ProductoRegistro> productos) {
        if (estrategia == null) {
            throw new IllegalStateException("No se ha definido una estrategia de análisis");
        }
            estrategia.analizar(productos);
        }
 }
