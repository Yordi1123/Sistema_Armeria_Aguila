package com.armeria.sistema.modelo.AbstractFactori.Interface;
import java.time.LocalDate;

import com.armeria.sistema.modelo.AbstractFactori.docPago.*;
import com.armeria.sistema.modelo.AbstractFactori.tipoElectronico.docElectronico;
import com.armeria.sistema.modelo.AbstractFactori.tipoFisico.*;

public class FacBolDocFisico implements FabricaComprobanteDocumento {

    @Override
    public boleta creaBoleta() {
        return new BoletaFisica("", "", "", "", "", "", "", LocalDate.now(), 0.0, "");  

    }

    @Override
    public factura creaFactura() {
        return new FacturaFisica("", "", "", "", "", "", LocalDate.now(), 0.0, "");
    }

    @Override
    public docTrasladoArma creaDocTrasladoArma() {
        return new docElectronico("", "", "", "", "", LocalDate.now(), 0.0, "", "");
    }
    
}
