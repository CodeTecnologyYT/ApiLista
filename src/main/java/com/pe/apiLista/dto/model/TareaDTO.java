package com.pe.apiLista.dto.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class TareaDTO {
    private Long idTarea;
    private String nombre;
    private Integer estado;
    private Date fechaVencimiento;
    private Long idLista;

}
