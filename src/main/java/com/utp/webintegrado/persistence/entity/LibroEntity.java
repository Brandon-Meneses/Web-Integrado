package com.utp.webintegrado.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "libro")
public class LibroEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_libro")
    private int idLibro;

    @Column(name = "titulo", nullable = false)
    private String titulo;

    @Column(name = "autor", nullable = false)
    private String autor;

    @Column(name = "isbn", nullable = false)
    private String isbn;

    @Column(name = "editorial", nullable = false)
    private String editorial;

    @Column(name = "anio_publicacion", nullable = false)
    private int anioPublicacion;

    @Column(name = "stock_total", nullable = false, columnDefinition = "INT DEFAULT 0")
    private int stockTotal;

    @Column(name = "descripcion")
    private String descripcion;

}
