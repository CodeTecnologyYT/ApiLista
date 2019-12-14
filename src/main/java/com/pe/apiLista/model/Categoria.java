package com.pe.apiLista.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "CATEGORIAS")
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@SequenceGenerator(name = "SEQ_CATEGORIA", sequenceName = "SEQ_CATEGORIA", initialValue = 1, allocationSize = 1)
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_CATEGORIA")
    @Column(name = "ID_CATEGORIA")
    private Long idCategoria;

    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "ESTADO", insertable=false)
    private Integer estado;

    @Column(name = "FECHA_CREACION",insertable=false)
    private Date fechaCreacion;

    @Column(name = "FECHA_MODIFICACION")
    private Date fechaModificacion;

    public Categoria(String nombre) {
        this.nombre = nombre;
    }


}
