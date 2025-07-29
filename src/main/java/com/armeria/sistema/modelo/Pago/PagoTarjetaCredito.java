package com.armeria.sistema.modelo.Pago;
import java.util.Scanner;
public class PagoTarjetaCredito implements MetodoPago {

    Scanner scanner = new Scanner(System.in);

    @Override
    public void procesarPago(double monto) {
        if (monto <= 0) {
            System.out.println("Monto inválido. El pago no puede procesarse");
            return;
        }

        System.out.println("---- Pago con Tarjeta de Crédito ----");

        System.out.print("Ingrese el nombre del titular: ");
        String titular = scanner.nextLine();

        System.out.println("Procesando pago...");
        System.out.println("Pago realizado por S/ " + monto + " con tarjeta de crédito");
    }
}
