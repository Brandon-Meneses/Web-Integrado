package com.utp.webintegrado.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "transferencia")
public class TransferenciaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_transferencia")
    private int idTransferencia;

    @ManyToOne
    @JoinColumn(name = "id_sucursal_origen", referencedColumnName = "id_sucursal", nullable = false)
    private SucursalEntity sucursalOrigen;

    @ManyToOne
    @JoinColumn(name = "id_sucursal_destino", referencedColumnName = "id_sucursal", nullable = false)
    private SucursalEntity sucursalDestino;

    @ManyToOne
    @JoinColumn(name = "id_libro", referencedColumnName = "id_libro", nullable = false)
    private LibroEntity libro;

    @Column(name = "cantidad", nullable = false)
    private int cantidad;

    @Column(name = "fecha", nullable = false)
    private LocalDate fecha;

}
