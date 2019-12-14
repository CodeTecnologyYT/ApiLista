package com.pe.apiLista.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@Builder
@Table(name = "TAREAS")
@SequenceGenerator(name = "seq", sequenceName = "SEQ_TAREA", initialValue = 1, allocationSize = 1)
public class Tarea {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @Column(name = "ID_TAREA")
    private Long idTarea;

    @Column(name="NOMBRE")
    @NotNull
    private String nombre;

    @Column(name="FECHA_CREACION",insertable = false)
    private Date fecha_creacion;

    @Column(name="ESTADO",insertable = false)
    private Integer estado;

    @Column(name="FECHA_VENCIMIENTO")
    private Date fechaVencimiento;

    @ManyToOne
    @JoinColumn(name = "ID_LISTA")
    private Lista lista;

    public Tarea(){
        super();
    }



}
