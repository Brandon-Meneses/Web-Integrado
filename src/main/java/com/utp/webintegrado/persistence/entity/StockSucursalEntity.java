package com.utp.webintegrado.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "stock_sucursal")
public class StockSucursalEntity {

    @EmbeddedId
    private StockSucursalId id;

    private int stock;

    @MapsId("id_sucursal")
    @ManyToOne
    @JoinColumn(name = "id_sucursal", referencedColumnName = "id_sucursal", insertable = false, updatable = false)
    private SucursalEntity sucursal;

    @MapsId("id_libro")
    @ManyToOne
    @JoinColumn(name = "id_libro", referencedColumnName = "id_libro", insertable = false, updatable = false)
    private LibroEntity libro;

}