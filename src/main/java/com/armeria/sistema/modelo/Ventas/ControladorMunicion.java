package com.armeria.sistema.modelo.Ventas;

import java.util.Map;
import java.util.Scanner;

public class ControladorMunicion extends ControladorBase {

    private static final Map<TipoLicencia, Integer> LIMITES_MUNICIONES = Map.of(
            TipoLicencia.L1_DEFENSA_PERSONAL, 500,
            TipoLicencia.L2_SEGURIDA_DPRIVADA, 1000,
            TipoLicencia.L3_CAZA_DEPORTIVA, 1000,
            TipoLicencia.L4_TIRO_DEPORTIVO, 3000
    );

    // Registrar producto tipo arma, verifica si el cliente tiene licencia
    @Override
    public boolean registrarProducto(Cliente cliente, ItemVenta itemventa) {
        if (itemventa.getProducto().getTipo().equals(TipoProducto.MUNICION) ){
            return validarRegistro(cliente, itemventa);
        } else {
            System.out.println("El producto no es municion.");
        }
        return validarSiguiente(cliente, itemventa);
    }

    @Override
    public boolean validarRegistro(Cliente cliente, ItemVenta itemventa) {

        Producto producto = itemventa.getProducto();

        // 1. Verificar licencia vigente
        if (!cliente.isTieneLicencia()) {
            System.out.println("El comprador no posee una licencia vigente.");
            return false;
        }

        // 2. Validar compatibilidad técnica
        if (!esCompatibleConArmaRegistrada(producto)) {
            System.out.println("El comprador no posee un arma registrada compatible con la munición.");
            return false;
        }


        // 3. Validar cantidad permitida según modalidad
        if (excedeLimitePermitido(cliente, itemventa)) {
            System.out.println("El cliente excede el límite de municiones permitidas según su tipo de licencia.");
            return false;
        }

        // 4. Calcular impuestos IGV del 18%
        double impuestoMunicion = 0.18;
        itemventa.setImpuesto(impuestoMunicion);

        return true;
    }

    // Metodo para obtener el registro de compras de municiones del cliente en un mes
    public void registroCompraMuniciones(Cliente cliente){

        for (Comprobante registro : RegistroVentas.obtenerVentas()) {
            // Verifica si el cliente coincide con el registro de pago
            if (cliente.getDni().equals(registro.getPago().getCliente().getDni())) {
                System.out.println();
            }
        }
    }


    private boolean esCompatibleConArmaRegistrada( Producto producto) {
        System.out.println("solicitar compatibilidad técnica de la munición (" + producto.getNombre()+") con el arma registrada.");
        System.out.println("¿La municion es compatible con el tipo y calibre del arma registrada? (s/n)");
        String respuesta = new Scanner(System.in).nextLine().trim().toLowerCase();
        if (!respuesta.equals("s")) {
            return false;
        }
        return true;
    }

    private boolean excedeLimitePermitido(Cliente cliente, ItemVenta itemVenta) {
        TipoLicencia tipoLicencia = cliente.getTipoLicencia();

        // Licencia tipo colección no permite comprar municiones
        if (tipoLicencia == TipoLicencia.L5_COLECCION) {
            System.out.println("No se puede comprar municiones con licencia de colección.");
            return true; // cambia a true si deseas bloquear la compra
        }

        // Licencia institucional: sin restricción
        if (tipoLicencia == TipoLicencia.L6_INSTIUCIONAL) {
            System.out.println("Compra institucional. No hay límite.");
            return false;
        }

        // Obtener límite permitido según licencia
        Integer limite = LIMITES_MUNICIONES.get(tipoLicencia);
        if (limite == null) {
            throw new IllegalArgumentException("Tipo de licencia no válido o no definido.");
        }

        int cantidadSolicitada = itemVenta.getCantidad();
        System.out.printf("Comprando municiones con licencia %s. Límite: %d cartuchos/año.%n",
                tipoLicencia.name(), limite);
        System.out.println("Cantidad solicitada: " + cantidadSolicitada);

        // Simulación de validación
        if (cantidadSolicitada > limite) {
            System.out.println("La cantidad solicitada excede el límite permitido.");
            return true;
        }

        // Confirmar si realmente está excediendo el total anual
        return confirmarExcesoUsuario();
    }

    private boolean confirmarExcesoUsuario() {
        System.out.println("¿Confirma que la cantidad total no supera el límite anual? (s/n)");
        Scanner scanner = new Scanner(System.in);
        String respuesta = scanner.nextLine().trim().toLowerCase();
        return respuesta.equals("s");
    }

}
