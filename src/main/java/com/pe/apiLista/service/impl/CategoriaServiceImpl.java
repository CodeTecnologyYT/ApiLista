package com.pe.apiLista.service.impl;

import com.pe.apiLista.dto.model.CategoriaDTO;
import com.pe.apiLista.model.Categoria;
import com.pe.apiLista.repository.CategoriaRepository;
import com.pe.apiLista.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    CategoriaRepository categoriaRepository;

    public Optional<List<CategoriaDTO>> listarCategoria(){
        List<Categoria> listaCategoria= new ArrayList<>();
        categoriaRepository.findAll().iterator().forEachRemaining(listaCategoria::add);
        List<CategoriaDTO> categoriaDTOS = listaCategoria.stream().map(categoria ->{
            CategoriaDTO categoriaDTO = CategoriaDTO.builder()
                    .idCategoria(categoria.getIdCategoria())
                    .nombre(categoria.getNombre()).build();
            return categoriaDTO;
        }).collect(Collectors.toList());
        return Optional.of(categoriaDTOS);
    }
}
