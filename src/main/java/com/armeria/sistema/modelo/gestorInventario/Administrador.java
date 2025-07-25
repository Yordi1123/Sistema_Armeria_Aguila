package com.armeria.sistema.modelo.gestorInventario;

public class Administrador {

    public static void main(String[] args) {
        GestorArma gestorArmas = new GestorArma();
        GestorMunicion gestorMunicion = new GestorMunicion();
        GestorAccesorio gestorAccesorio = new GestorAccesorio();

        // AGREGAMOS ARMAS
        ProductoArma pistola = new ProductoArma("A001", "PistolaGlock 17", "Pistola",
                "0.9", 2800.0, "Glock", "17 Gen5", "Austria",
                "9mm", 114.0, 17, "Manual");
        ProductoArma escopeta = new ProductoArma("A002", "EscopetaRemington 870", "Escopeta",
                "3.1", 3400.0, "Remington", "870 Express",
                "EE.UU.", "12 GA", 508.0, 5, "Manual");

        gestorArmas.registrarProducto(pistola);
        gestorArmas.registrarProducto(escopeta);
        gestorArmas.mostrarInventario();

        // AGREGAMOS MUNICIONES
        ProductoMunicion municionPistola = new ProductoMunicion("M001", "Caja de Balas 9mm",
                "Munición", "0.45", 110.0, "Winchester", "FMJ-9",
                "EE.UU.", "9mm", 50);
        ProductoMunicion municionEscopeta = new ProductoMunicion("M002", "Cartuchos 12 GA",
                "Munición", "0.75", 160.0, "Remington", "Slugger",
                "EE.UU.", "12 GA", 25);

        gestorMunicion.registrarProducto(municionPistola);
        gestorMunicion.registrarProducto(municionEscopeta);
        gestorMunicion.mostrarInventario();

        // AGREGAMOS ACCESORIOS
        ProductoAccesorio accesorioPistola = new ProductoAccesorio("A001", "Mira Láser Roja",
                "Accesorio", "0.2", 300.0, "Crimson Trace", "LG-403", "EE.UU.", "Mejorar puntería");
        ProductoAccesorio accesorioEscopeta = new ProductoAccesorio("A003", "Culata Retráctil Táctica",
                "Accesorio", "0.8", 520.0, "Magpul", "SGA Stock",
                "EE.UU.", "Mejorar ergonomía y control");

        gestorAccesorio.registrarProducto(accesorioPistola);
        gestorAccesorio.registrarProducto(accesorioEscopeta);
        gestorAccesorio.mostrarInventario();
    }
}
