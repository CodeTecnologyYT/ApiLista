package com.pe.apiLista.service;

import com.pe.apiLista.dto.model.TareaDTO;

import java.util.List;
import java.util.Optional;

public interface TareaService {

    Optional<TareaDTO> agregarTarea(TareaDTO tareaDTO);
    Optional<List<TareaDTO>> listarTareas(Long idTarea);
    Optional<TareaDTO> actualizarEstadoTarea(TareaDTO tareaDTO);
}
