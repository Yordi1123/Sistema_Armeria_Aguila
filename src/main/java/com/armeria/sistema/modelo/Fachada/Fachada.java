package com.armeria.sistema.modelo.Fachada;
import com.armeria.sistema.modelo.Pago.PagoService;
import com.armeria.sistema.modelo.Ventas.VentaService;
import com.armeria.sistema.modelo.gestorInventario.InventarioService;
import com.armeria.sistema.modelo.Mediador.Mediador;

public class Fachada {
    private Mediador mediador;
    private InventarioService inventarioService;
    private VentaService ventaService;
    private PagoService pagoService;

    public Fachada() {
        // Crear mediador y servicios
        this.mediador = new Mediador();
        this.inventarioService = new InventarioService(mediador);
        this.ventaService = new VentaService(mediador);
        this.pagoService = new PagoService(mediador);
        // Registrar servicios en el mediador
        mediador.agregarServicio(ventaService);
        mediador.agregarServicio(pagoService);
        mediador.agregarServicio(inventarioService);
    }

    public void iniciarSistema() {
        inventarioService.cargarInventario();
    }
    public void mostrarInventario() {
        inventarioService.mostrarCatalogo();
    }
    public void iniciarProcesoVenta() {
        ventaService.iniciarProcesoVenta();
    }
}
