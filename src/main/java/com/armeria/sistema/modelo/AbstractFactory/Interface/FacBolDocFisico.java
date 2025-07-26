package com.armeria.sistema.modelo.AbstractFactory.Interface;
import java.time.LocalDate;

import com.armeria.sistema.modelo.AbstractFactory.docPago.*;
import com.armeria.sistema.modelo.AbstractFactory.tipoFisico.*;

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
        return new docFisico("","","","","","", LocalDate.now(), "", 0.0, "", "");
    }
    
}
