package com.armeria.sistema.modelo.ComprobantePago;

import java.time.LocalDate;

public class FabricaComDocElectronico implements FabricaComprobanteDocumento {

    @Override
    public Boleta creaBoleta() {
        return new BoletaElectronica(
            "B001", "12345678", "Tejada Quiroz Roberto Ivan", "Jr. Elias Aguirre 238 Of. 204",
            "Mendoza Valiente Jhonatan Raul", "987654321",
            LocalDate.now(), 150.50, "SEC001", "QR123", "SUNAC001"
        );
    }

    @Override
    public Factura creaFactura() {
        return new FacturaElectronica(
            "F001", "20445412628", "Tejada Quiroz Roberto Ivan", "Jr. Elias Aguirre 238 Of. 204",
            "Mendoza Valiente Jhonatan Raul", "20987654321",
            LocalDate.now(), 450.75, "SUNAC999"
        );
    }

    @Override
    public DocumentoTrasladoBienesArmas creaDocumento() {
        return new DocumentoElectronico(
            "Tejada Quiroz Roberto Ivan",                 // nombreVendedor
            "20445412628",                                // rucEmpresa
            "Jr. Elias Aguirre 238 Of. 204",              // direccionEmpresa
            "Mendoza Valiente Jhonatan Raul",             // nombreCliente
            "987654321",                                  // dniCliente
            "Miraflores Bajo III Zona Psj. Los Angeles",  // direccionCliente
            LocalDate.now(),                              // fechaEmision
            "Transferencia de arma BERSA",                // descripcionBienes
            2097.0,                                        // montoTotal
            "Pistola BERSA",                               // arma
            "SUNAT-X123",                                  // codSunat
            "SUCAMET-001"                                  // Sucamet
        );
    }
}
