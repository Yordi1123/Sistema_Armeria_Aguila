package com.armeria.sistema.modelo.Ventas;

import java.util.List;

public class ProcesadorVenta {
    private EstrategiaVenta estrategiaVenta;
    private List<ItemVenta> itemVenta;
    private Cliente cliente;

    public ProcesadorVenta(EstrategiaVenta estrategiaVenta) {
        this.estrategiaVenta = estrategiaVenta;
    }


    public void procesarVenta(){
        estrategiaVenta.procesarVenta(itemVenta, cliente);
    }

}

