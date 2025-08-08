package com.armeria.sistema.modelo.Ventas;
import com.armeria.sistema.modelo.Mediador.*;

public class VentaService  extends Servicio {
    Venta venta;
    public VentaService (IMediador mediador){
        this.setMediador(mediador);
    }

    public VentaService() {
    }

    @Override
    public void recibir(Mensaje mensaje) {
        System.out.println("VentaService recibió el mensaje: " + mensaje.getDescripcion());
        venta.registrarPago(mensaje.getPago());
    }

    public void iniciarProcesoVenta(){
        venta = new Venta();
        venta.solicitarDatosCliente();
        venta.registrarProductos();
        if(venta.verificarCompra()== true){
            solicitarPago(venta);
            solicitarActualizarInventario(venta.getCarrito());
        }
    }

    public void solicitarPago(Venta venta){

        Cliente cliente = venta.getCliente();
        double monto = venta.getTotalConIgv();
        String descrip = "Solicitando procesar pago";

        Mensaje mensaje = new Mensaje (cliente, monto, descrip);

        comunicar(mensaje);
    }


    public void solicitarActualizarInventario(CarritoCompra carrito) {
        Mensaje mensaje = new Mensaje(carrito, "Solicitando actualizar inventario");
        comunicar(mensaje);
    }
}
