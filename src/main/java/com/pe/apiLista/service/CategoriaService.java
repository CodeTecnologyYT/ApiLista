package com.pe.apiLista.service;

import com.pe.apiLista.dto.model.CategoriaDTO;

import java.util.List;
import java.util.Optional;

public interface CategoriaService {
   Optional<List<CategoriaDTO>> listarCategoria();
}
