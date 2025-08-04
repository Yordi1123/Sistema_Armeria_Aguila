package com.armeria.sistema.modelo.Pago;

import com.armeria.sistema.modelo.Ventas.Cliente;
import java.util.Scanner;

public class PagoService {
    Cliente cliente;
    double monto;
    private MetodoPago metodo;

    Scanner scanner = new Scanner(System.in);

    public PagoService() {
    }

    public void pagar() {
        if (metodo != null) {
            metodo.procesarPago(monto);
        } else {
            System.out.println("No se ha seleccionado un método de pago");
        }
    }

    public void ingresarMonto(){
        System.out.print("Ingrese el monto a pagar: S/ ");
        double monto = scanner.nextDouble();
        scanner.nextLine();
    }

    public void selectMetodo(){
        System.out.println("=== Sistema de Pago - Armería ===");
        System.out.println("Métodos disponibles:");
        System.out.println("1. Tarjeta de Crédito");
        System.out.println("2. Tarjeta de Débito");
        System.out.println("3. Efectivo");
        System.out.println("4. Transferencia Bancaria");
        System.out.println("5. Yape");
        System.out.println("6. Plin");

        System.out.print("Seleccione el método de pago (1-6): ");
        int opcion = scanner.nextInt();

        switch (opcion) {
            case 1: setMetodoPago(new PagoTarjetaCredito());
                break;
            case 2: setMetodoPago(new PagoTarjetaDebito());
                break;
            case 3: setMetodoPago(new PagoEfectivo());
                break;
            case 4: setMetodoPago(new PagoTransferencia());
                break;
            case 5: setMetodoPago(new PagoYape());
                break;
            case 6: setMetodoPago(new PagoPlin());
                break;
            default:
                System.out.println("Opción no válida.");
                return;
        }
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public void setMetodoPago(MetodoPago metodo) {
        this.metodo = metodo;
    }
}
