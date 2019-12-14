package com.pe.apiLista.controller.v1.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class ListaRequest {

    @NotNull
    private String  nombre;
    @NotNull
    private Long idCategoria;

}
