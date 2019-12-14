package com.pe.apiLista.service;

import com.pe.apiLista.dto.model.ListaDTO;

import java.util.List;
import java.util.Optional;

public interface ListaService {
    Optional<ListaDTO> agregarLista(ListaDTO listaDTO);
    Optional<List<ListaDTO>> listarLista();
    Optional<ListaDTO> actualizarEstado(ListaDTO listaDTO);
}
