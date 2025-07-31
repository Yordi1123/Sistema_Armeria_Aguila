package com.armeria.sistema.modelo.ComprobantePago;

import java.time.LocalDate;

public class FabricaComDocFisico implements FabricaComprobanteDocumento {

    @Override
    public Boleta creaBoleta() {
        return new BoletaFisica(
            "B002", "12345679", "Tejada Quiroz Roberto Ivan", "Jr. Elias Aguirre 238 Of. 204",
            "Mendoza Valiente Jhonatan Raul", "987654321",
            LocalDate.now(), 200.00, "Chimbote"
        );
    }

    @Override
    public Factura creaFactura() {
        return new FacturaFisica(
            "F002", "20445412628", "Tejada Quiroz Roberto Ivan", "Jr. Elias Aguirre 238 Of. 204",
            "Mendoza Valiente Jhonatan Raul", "20987654320",
            LocalDate.now(), 600.00, "Chimbote"
        );
    }

    @Override
    public DocumentoTrasladoBienesArmas creaDocumento() {
     return new DocumentoFisico(
    "Tejada Quiroz Roberto Ivan",         // nombreVendedor
    "20445412628",                        // rucEmpresa
    "Jr. Elias Aguirre 238 Of. 204",      // direccionEmpresa
    "Mendoza Valiente Jhonatan Raul",     // nombreCliente
    "987654321",                          // dniCliente
    "Miraflores Bajo III Zona Psj. Los Angeles", // direccionCliente
    LocalDate.now(),                     // fechaEmision
    "Escopeta AKKAR",                    // descripcionBienes
    2000.0,                               // montoTotal
    "AKKAR-12GA",                         // arma
    "Chimbote"                            // oficina
);

    }
}
