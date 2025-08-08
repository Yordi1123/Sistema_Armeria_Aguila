package com.armeria.sistema.modelo.gestorInventario;

import com.armeria.sistema.modelo.Mediador.IMediador;
import com.armeria.sistema.modelo.Mediador.Mensaje;
import com.armeria.sistema.modelo.Mediador.Servicio;

public class InventarioService extends Servicio {
    private GestorProducto gestorArmas;
    private GestorProducto gestorMunicion;
    private GestorProducto gestorAccesorio;

    public InventarioService(IMediador mediador) {
        this.mediador = mediador;
        this.gestorArmas = new GestorArma();
        this.gestorMunicion = new GestorMunicion();
        this.gestorAccesorio = new GestorAccesorio();
    }

    public InventarioService() {
        this.gestorArmas = new GestorArma();
        this.gestorMunicion = new GestorMunicion();
        this.gestorAccesorio = new GestorAccesorio();
    }

    public void cargarInventario(){
        crearArma();
        crearMunicion();
        crearAccesorio();
    }

    public void mostrarCatalogo(){
        gestorArmas.mostrarCatalogo();
        gestorAccesorio.mostrarCatalogo();
        gestorMunicion.mostrarCatalogo();
    }


    public void crearArma(){
        ProductoArmeria arma1 = new ProductoArma("A001", "Pistola Glock 17", TipoProducto.ARMA,
                750.50, "Glock", "17", 10, "9mm", 15.5,
                17, "sí", "Austria", "0.9 kg");

        ProductoArmeria arma2 = new ProductoArma("A002", "Rifle AK-47", TipoProducto.ARMA,
                7500.50, "Kalashnikov", "AK-47", 5, "7.62mm", 41.5,
                30, "no", "Rusia", "4.3 kg");

        ProductoArmeria arma3 = new ProductoArma("A003", "Escopeta Remington 870", TipoProducto.ARMA,
                5300.50, "Remington", "870", 8, "12 gauge", 46.0,
                7, "no", "USA", "3.6 kg");

        ProductoArmeria arma4 = new ProductoArma("A004", "Subfusil Uzi", TipoProducto.ARMA,
                4500.50, "IMI", "Uzi", 12, "9mm", 25.0,
                25, "sí", "Israel", "3.5 kg");

        ProductoArmeria arma5 = new ProductoArma("A005", "Rifle de francotirador", TipoProducto.ARMA,
                12000.50, "Barrett", "M82", 3, "12.7mm", 73.7,
                10, "no", "USA", "14 kg");
        gestorArmas.registrarProducto(arma1);
        gestorArmas.registrarProducto(arma2);
        gestorArmas.registrarProducto(arma3);
        gestorArmas.registrarProducto(arma4);
        gestorArmas.registrarProducto(arma5);
    }

    public void crearMunicion(){
        ProductoArmeria municion1 = new ProductoMunicion("M001", "Munición 9mm FMJ", TipoProducto.MUNICION,
                57.00, "Glock", "FMJ-9", 50, "9mm", 50);  // S/57 por caja

        ProductoArmeria municion2 = new ProductoMunicion("M002", "Munición 7.62mm OTAN", TipoProducto.MUNICION,
                76.00, "Kalashnikov", "M80", 30, "7.62mm", 50);  // S/76 por caja

        ProductoArmeria municion3 = new ProductoMunicion("M003", "Cartuchos 12 gauge", TipoProducto.MUNICION,
                66.50, "Remington", "Slug-12", 20, "12 gauge", 25);  // S/66.50 por caja

        ProductoArmeria municion4 = new ProductoMunicion("M004", "Munición 9mm Uzi", TipoProducto.MUNICION,
                60.80, "IMI", "Uzi-9", 40, "9mm", 50);  // S/60.80 por caja

        ProductoArmeria municion5 = new ProductoMunicion("M005", "Cartuchos 12.7mm BMG", TipoProducto.MUNICION,
                133.00, "Barrett", "BMG-M33", 5, "12.7mm", 10);  // S/133 por caja

        gestorMunicion.registrarProducto(municion1);
        gestorMunicion.registrarProducto(municion2);
        gestorMunicion.registrarProducto(municion3);
        gestorMunicion.registrarProducto(municion4);
        gestorMunicion.registrarProducto(municion5);
    }

public void crearAccesorio() {
    ProductoArmeria accesorio1 = new ProductoAccesorio("AC001", "Correa portafusil táctica", TipoProducto.ACCESORIO,
            45.90, "TactiPro", "CRP-M4", 30, "correa ajustable para transporte seguro del arma");

    ProductoArmeria accesorio2 = new ProductoAccesorio("AC002", "Linterna táctica LED", TipoProducto.ACCESORIO,
            89.00, "LuxFire", "LT-X300", 20, "linterna de alta luminosidad con montura Picatinny");

    ProductoArmeria accesorio3 = new ProductoAccesorio("AC003", "Funda universal para pistola", TipoProducto.ACCESORIO,
            35.85, "SafeGear", "FND-GEN", 40, "funda de nylon resistente para almacenamiento");

    ProductoArmeria accesorio4 = new ProductoAccesorio("AC004", "Protector de gatillo seguro", TipoProducto.ACCESORIO,
            12.50, "TriggerSafe", "PTC-001", 50, "cubre el gatillo para evitar disparos accidentales");

    ProductoArmeria accesorio5 = new ProductoAccesorio("AC005", "Bípode ajustable", TipoProducto.ACCESORIO,
            75.00, "StableShot", "BPD-6IN", 15, "soporte regulable para mayor precisión en disparos");

        gestorAccesorio.registrarProducto(accesorio1);
        gestorAccesorio.registrarProducto(accesorio2);
        gestorAccesorio.registrarProducto(accesorio3);
        gestorAccesorio.registrarProducto(accesorio4);
        gestorAccesorio.registrarProducto(accesorio5);
    }

    @Override
    public void recibir(Mensaje mensaje) {
        if (mensaje == null || mensaje.getCarrito() == null) {
            return;
        }
        System.out.println("InventarioService recibió el mensaje: " + mensaje.getDescripcion());
        gestorArmas.actualizarStockGeneral(mensaje.getCarrito());
    }
}
