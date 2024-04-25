package com.utp.webintegrado.persistence.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "stock_sucursal")
public class StockSucursalEntity{

    @Id
    @ManyToOne
    @JoinColumn(name = "id_sucursal", referencedColumnName = "id_sucursal")
    private SucursalEntity sucursal;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_libro", referencedColumnName = "id_libro")
    private LibroEntity libro;

    @Column(name = "stock", nullable = false, columnDefinition = "INT DEFAULT 0")
    private int stock;

}
