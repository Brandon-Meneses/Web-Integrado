package com.utp.webintegrado.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class StockSucursalEntityPK {

    @Column(name = "id_sucursal")
    private int idSucursal;

    @Column(name = "id_libro")
    private int idLibro;

}
