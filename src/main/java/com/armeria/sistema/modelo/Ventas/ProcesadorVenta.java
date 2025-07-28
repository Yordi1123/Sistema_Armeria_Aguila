package com.armeria.sistema.modelo.Ventas;

import java.util.List;
import java.util.Scanner;

public class ProcesadorVenta {
    private EstrategiaVenta estrategiaVenta;
    //private List<ItemVenta> itemVenta;
    private Cliente cliente;

    public ProcesadorVenta(EstrategiaVenta estrategiaVenta) {
        this.estrategiaVenta = estrategiaVenta;
    }


    public void procesarVenta(Cliente cliente){
        System.out.println("Inciando el proceso de venta para el cliente: " + cliente.getNombre() + " " + cliente.getApellido());
        estrategiaVenta.procesarVenta(cliente);
    }

    // Nuevo metodo para solicitar los datos del cliente
    public Cliente solicitarDatosCliente() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese DNI del cliente: ");
        String dni = scanner.nextLine().trim();

        System.out.print("Ingrese nombre del cliente: ");
        String nombre = scanner.nextLine().trim();

        System.out.print("Ingrese apellido del cliente: ");
        String apellido = scanner.nextLine().trim();

        System.out.print("¿El cliente tiene licencia para comprar armas? (s/n): ");
        String respuesta = scanner.nextLine().trim().toLowerCase();
        boolean tieneLicencia = respuesta.equals("s") || respuesta.equals("si");

        return new Cliente(dni, nombre, apellido, tieneLicencia);
    }

}

