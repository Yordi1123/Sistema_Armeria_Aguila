package com.armeria.sistema.modelo.Proxy;

import com.armeria.sistema.modelo.Fachada.Fachada;

public class OperacionReal implements Operacion {
    private Fachada fachada;

    // Constructor para inyectar la fachada
    public OperacionReal(Fachada fachada) {
        this.fachada = fachada;
    }

    @Override
    public void ejecutar() {
System.out.println("\n=============================================");
System.out.println("         Accediendo al sistema...          ");
System.out.println("=============================================");
System.out.println("    BIENVENIDO AL SISTEMA DE VENTAS DE     ");
System.out.println("               ARMERÍA                      ");
System.out.println("=============================================\n");
        
        // Uso real de la fachada
        fachada.iniciarSistema();
        fachada.mostrarInventario();
        fachada.iniciarProcesoVenta();
        fachada.mostrarInventario();
    }
}
