package com.pe.apiLista.model;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="LISTAS")
@SequenceGenerator(name = "seq", sequenceName = "SEQ_LISTA", initialValue = 1, allocationSize = 1)
public class Lista {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "seq")
    @Column(name = "ID_LISTA")
    private Long idLista;

    @Column(name="NOMBRE")
    private String nombre;

    @Column(name="FECHA_CREACION",insertable = false)
    private Date fechaCreacion;


    @Column(name="ESTADO",insertable = false)
    private Integer estado;

    @ManyToOne
    @JoinColumn(name="ID_CATEGORIA")
    private Categoria categoria;

}
