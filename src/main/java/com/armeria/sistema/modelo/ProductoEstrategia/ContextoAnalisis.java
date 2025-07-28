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
        else{
            System.out.println("No se ha seleccionado una estrategia de analisis. Por favor, elija una estrategia válida."); // Mensaje de error si no se ha definido una estrategia
        }
    }
}
