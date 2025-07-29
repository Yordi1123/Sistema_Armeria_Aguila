package com.armeria.sistema.modelo.Ventas;

import java.util.Scanner;

public class Venta {
    private Cliente cliente;
    private CarritoCompra carrito;


    public Venta() {
    }

    // Metodo para solicitar los datos del cliente
    public void solicitarDatosCliente() {
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

        this.cliente = new Cliente(dni, nombre, apellido, tieneLicencia);
        this.carrito = new CarritoCompra(cliente);
    }

    // Registrar producto en el carrito de compras
    public void registrarProductos() {
        carrito.procesarProductos();
    }

    // Registrar producto en el carrito de compras
    public double calcularTotalVenta() {

        double total = 0;
        for (ItemVenta item : carrito.getItemVentaList()) {
            total += item.calcularSubtotal();
        }
        return total;
    }


    // Procesar el pago del cliente
    public void procesarPago() {
        Pago pagoCliente = new Pago(cliente, calcularTotalVenta());
        if (!pagoCliente.procesarPago()) {
            System.out.println("El pago no se pudo procesar. Venta cancelada.");
            return;
        }

        imprimirComprobante(pagoCliente);
    }

    // Actualizar el inventario después de procesar la venta
    public void actualizarInventario() {
        Inventario.actualizarStockGeneral(carrito);
        System.out.println("Venta procesada exitosamente. Gracias por su compra, " + cliente.getNombre() + ".");
    }

    // Imprimir el comprobante de pago
    // Este metodo se encarga de generar el comprobante de pago después de que se haya
    public void imprimirComprobante(Pago pagoCliente) {
        pagoCliente.generarComprobante(carrito);
    }

}
