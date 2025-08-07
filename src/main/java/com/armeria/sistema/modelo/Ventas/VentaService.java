package com.armeria.sistema.modelo.Ventas;

import com.armeria.sistema.modelo.Mediador.*;
import com.armeria.sistema.modelo.Pago.Pago;
import com.armeria.sistema.modelo.gestorInventario.GestorProducto;
import com.armeria.sistema.modelo.gestorInventario.ProductoArma;
import com.armeria.sistema.modelo.gestorInventario.ProductoArmeria;
import com.armeria.sistema.modelo.gestorInventario.TipoProducto;

public class VentaService  extends Servicio {
    Venta venta;
    public VentaService (IMediador mediador){
        this.setMediador(mediador);
    }


    public static void main(String[] args) {

        System.out.println("Inventario actualizado después de la venta:");
        Inventario.mostrarInventario();


    }

    @Override
    public void recibir(Mensaje mensaje) {
        System.out.println(mensaje.getDescripcion());
        Pago pago = mensaje.getPago();
        venta.registrarPago(pago);
    }

    public void iniciarProcesoVenta(){
        venta = new Venta();
        venta.solicitarDatosCliente();
        venta.registrarProductos();
        if(venta.verificarCompra()== true)
            solicitarPago(venta);
    }
    public void cargarInventario(){
        // Crear producto

        ProductoArmeria arma = new ProductoArma("A001", "PistolaGlock 17", TipoProducto.ARMA,
                0.9, "2800", "Glock", 10, "9mm",15.5,
                10, "no", "Austria", "2 kg");

        // Agregar productos al inventario
        Inventario.agregarProducto(arma);
        GestorProducto.registrarProducto(arma);

    }

    public void solicitarPago(Venta venta){

        Cliente cliente = venta.getCliente();
        double monto = venta.getTotalConIgv();
        String descrip = "Solicitando procesar pago";

        Mensaje mensaje = new Mensaje (cliente, monto, descrip);

        comunicar(mensaje);
    }
}
