package com.armeria.sistema.modelo.Ventas;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Venta {
    private Cliente cliente;
    private CarritoCompra carrito;
    private Pago pago;
    private Comprobante comprobante;


    public Venta() {
    }

    // Metodo para solicitar los datos del cliente
    public void solicitarDatosCliente() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("===== Registro de Cliente =====");

        // Solicitar y validar DNI
        String dni;
        do {
            System.out.print("Ingrese DNI del cliente (8 dígitos): ");
            dni = scanner.nextLine().trim();
            if (!dni.matches("\\d{8}")) {
                System.out.println("DNI inválido. Debe contener exactamente 8 dígitos numéricos.");
            }
        } while (!dni.matches("\\d{8}"));

        // Solicitar nombre
        String nombre;
        do {
            System.out.print("Ingrese nombre del cliente: ");
            nombre = scanner.nextLine().trim();
            if (nombre.isEmpty()) {
                System.out.println("El nombre no puede estar vacío.");
            }
        } while (nombre.isEmpty());

        // Solicitar apellido
        String apellido;
        do {
            System.out.print("Ingrese apellido del cliente: ");
            apellido = scanner.nextLine().trim();
            if (apellido.isEmpty()) {
                System.out.println("El apellido no puede estar vacío.");
            }
        } while (apellido.isEmpty());

        // Solicitar fecha de nacimiento y validar mayoría de edad
        LocalDate fechaNacimiento = null;
        while (true) {
            System.out.print("Ingrese fecha de nacimiento (YYYY-MM-DD): ");
            String fechaInput = scanner.nextLine().trim();
            try {
                fechaNacimiento = LocalDate.parse(fechaInput);
                int edad = Period.between(fechaNacimiento, LocalDate.now()).getYears();
                if (edad < 18) {
                    System.out.println("El cliente debe ser mayor de edad. Edad actual: " + edad + " años.");
                    return; // Detener el registro
                }
                break;
            } catch (DateTimeParseException e) {
                System.out.println("Formato de fecha inválido. Use el formato YYYY-MM-DD.");
            }
        }

        // Solicitar si tiene licencia
        boolean tieneLicencia;
        while (true) {
            System.out.print("¿El cliente tiene licencia para comprar armas? (s/n): ");
            String respuesta = scanner.nextLine().trim().toLowerCase();
            if (respuesta.equals("s") || respuesta.equals("si")) {
                tieneLicencia = true;
                break;
            } else if (respuesta.equals("n") || respuesta.equals("no")) {
                tieneLicencia = false;
                break;
            } else {
                System.out.println("Respuesta no válida. Escriba 's' para sí o 'n' para no.");
            }
        }

        // Crear cliente y carrito
        this.cliente = new Cliente(dni, nombre, apellido, tieneLicencia);
        this.cliente.setFechaNacimiento(fechaNacimiento);
        this.carrito = new CarritoCompra(cliente);

        System.out.println("Cliente registrado correctamente.");
    }


    // Registrar producto en el carrito de compras
    public void registrarProductos() {
        carrito.procesarProductos();
    }


    public double calcularTotalVenta() {

        double total = 0;
        for (ItemVenta item : carrito.getItemVentaList()) {
            total += item.calcularSubtotal();
        }
        return total;
    }

    public void mostrarVentaDetalles() {
        System.out.println("\n=====================================");
        System.out.println("         DETALLES DE LA VENTA        ");
        System.out.println("=====================================");
        System.out.printf("Cliente        : %s %s%n", cliente.getNombre(), cliente.getApellido());
        System.out.printf("DNI            : %s%n", cliente.getDni());
        System.out.printf("Tiene licencia : %s%n", cliente.isTieneLicencia() ? "Sí" : "No");
        System.out.println("-------------------------------------");
        System.out.println("Productos en el carrito:");
        System.out.println("-------------------------------------");
        System.out.printf("%-20s %-10s %-10s%n", "Producto", "Cantidad", "Subtotal");

        for (ItemVenta item : carrito.getItemVentaList()) {
            System.out.printf("%-20s %-10d S/ %-10.2f%n",
                    item.getProducto().getNombre(),
                    item.getCantidad(),
                    item.calcularSubtotal());
        }

        System.out.println("-------------------------------------");
        System.out.printf("TOTAL DE LA VENTA:       S/ %.2f%n", calcularTotalVenta());
        System.out.println("=====================================\n");
    }

    // Verificar la compra antes de procesar el pago
    public boolean verificarCompra(){
        System.out.println("Verificando venta...");
        mostrarVentaDetalles();

        System.out.println("1. continuar con el pago");
        System.out.println("2. modificar carrito");
        System.out.println("3. cancelar venta");
        System.out.print("Seleccione una opción: ");

        int opcion = new Scanner(System.in).nextInt();
        switch (opcion) {
            case 1:
                System.out.println("Continuando con el pago...");
                registrarPago();
                break;
            case 2:
                System.out.println("Modificando carrito...");
                registrarProductos();
                return verificarCompra(); // Volver a verificar la compra
            case 3:
                System.out.println("Venta cancelada.");
                return false;
            default:
                System.out.println("Opción inválida. Intente nuevamente.");
                return verificarCompra(); // Volver a verificar la compra
        }
        // Si se llega aquí, significa que la compra es válida
        return true;
    }

    // Procesar el pago del cliente
    public void registrarPago() {
        this.pago = new Pago(cliente, calcularTotalVenta());
        if (!pago.procesarPago()) {
            System.out.println("No se realizo el pago.");
            return;
        }
        actualizarInventario();
        this.comprobante = new Comprobante(pago, carrito);
        comprobante.generarComprobante();
        guardarVenta(comprobante);
    }

    // Actualizar el inventario después de procesar la venta
    public void actualizarInventario() {
        Inventario.actualizarStockGeneral(carrito);
        System.out.println("Venta procesada exitosamente. Gracias por su compra, " + cliente.getNombre() + ".");
    }

    public void guardarVenta(Comprobante comprobante) {
        // Aquí podrías implementar la lógica para guardar la venta en una base de datos o archivo
        RegistroVentas.registrarVenta(comprobante);
        System.out.println("Venta guardada exitosamente.");
    }

}
