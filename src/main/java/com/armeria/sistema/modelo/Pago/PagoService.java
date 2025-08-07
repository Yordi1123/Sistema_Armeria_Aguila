package com.armeria.sistema.modelo.Pago;

import com.armeria.sistema.modelo.Mediador.IMediador;
import com.armeria.sistema.modelo.Mediador.Mensaje;
import com.armeria.sistema.modelo.Mediador.Servicio;

import java.time.LocalDateTime;
import java.util.Scanner;

public class PagoService extends Servicio {
    Pago pago;
    private MetodoPago metodo;

    Scanner scanner = new Scanner(System.in);

    public PagoService(IMediador mediador) {
        this.setMediador(mediador);
    }

    public void pagar(Pago pago) {
        if (pago != null) {
            metodo.procesarPago(pago);
            pago.setValido(true);
            pago.setFechaPago(LocalDateTime.now());
        } else {
            System.out.println("No se ha seleccionado un método de pago");
            pago.setValido(false);
        }
    }

    public void selectMetodo() {
        System.out.println("""
                ╔═══════════════════════════════════════╗
                ║         SISTEMA DE PAGO - ARMERÍA     ║
                ╠═══════════════════════════════════════╣
                ║ Métodos disponibles:                  ║
                ║   1. Tarjeta de Crédito               ║
                ║   2. Tarjeta de Débito                ║
                ║   3. Efectivo                         ║
                ║   4. Yape                             ║
                ║   5. Plin                             ║
                ╚═══════════════════════════════════════╝
                """);

        System.out.print("Seleccione el método de pago (1-5): ");
        int opcion = scanner.nextInt();

        switch (opcion) {
            case 1:
                setMetodoPago(new PagoTarjetaCredito());
                break;
            case 2:
                setMetodoPago(new PagoTarjetaDebito());
                break;
            case 3:
                setMetodoPago(new PagoEfectivo());
                break;
            case 4:
                setMetodoPago(new PagoYape());
                break;
            case 5:
                setMetodoPago(new PagoPlin());
                break;
            default:
                System.out.println("Opción no válida.");
                return;
        }
    }

    @Override
    public void recibir(Mensaje mensaje) {
        if (mensaje == null || mensaje.getCliente() == null || mensaje.getMonto() <= 0) {
            return;
        }
        System.out.println("PagoService recibió el mensaje: " + mensaje.getDescripcion());
        procesarPago(mensaje);
    }

    public void procesarPago(Mensaje mensaje) {
        selectMetodo();
        pago = new Pago(mensaje.getCliente(),mensaje.getMonto());
        pagar(pago);
        confirmaPago();
    }

    public void confirmaPago() {
        String descrip = "Pago exitoso";
        Mensaje mensaje = new Mensaje(pago,descrip);
        comunicar(mensaje);
    }

    public void setMetodoPago(MetodoPago metodo) {
        this.metodo = metodo;
    }
}
