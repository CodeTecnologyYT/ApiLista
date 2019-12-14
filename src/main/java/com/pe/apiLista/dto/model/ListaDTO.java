package com.pe.apiLista.dto.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ListaDTO {

    private Long idLista;
    private String nombre;
    private Integer estado;
    private Long idCategoria;
}
