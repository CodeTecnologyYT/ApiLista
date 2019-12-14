package com.pe.apiLista.service.impl;

import com.pe.apiLista.dto.model.ListaDTO;
import com.pe.apiLista.model.Categoria;
import com.pe.apiLista.model.Lista;
import com.pe.apiLista.repository.CategoriaRepository;
import com.pe.apiLista.repository.ListaRepository;
import com.pe.apiLista.service.ListaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ListaServiceImpl implements ListaService {

    @Autowired
    CategoriaRepository categoriaRepository;

    @Autowired
    ListaRepository listaRepository;

    public Optional<ListaDTO> agregarLista(ListaDTO listaDTO){
        Categoria categoria=categoriaRepository.findById(listaDTO.getIdCategoria()).isPresent()?categoriaRepository.findById(listaDTO.getIdCategoria()).get():null;
        if(categoria!=null){
            Lista lista= Lista.builder()
                    .nombre(listaDTO.getNombre())
                    .categoria(categoria).build();
            Long idLista=listaRepository.save(lista).getIdLista();
            ListaDTO listaDTONueva = ListaDTO.builder().nombre(lista.getNombre()).idCategoria(listaDTO.getIdCategoria()).idLista(idLista).build();
            return Optional.of(listaDTONueva);
        }else{
            return Optional.empty();
        }
    }

    public Optional<List<ListaDTO>> listarLista(){
        List<Lista> listas=new ArrayList<>();
        listaRepository.findAll().iterator().forEachRemaining(listas::add);
        List<ListaDTO> listaDTOS=listas.stream().map(lista -> {
            ListaDTO listaDTO = ListaDTO.builder().idLista(lista.getIdLista())
                    .estado(lista.getEstado())
                    .nombre(lista.getNombre())
                    .build();
            return listaDTO;
        }).collect(Collectors.toList());
        return Optional.of(listaDTOS);
    }

    public Optional<ListaDTO> actualizarEstado(ListaDTO listaDTO){
        Lista lista = listaRepository.findById(listaDTO.getIdLista()).isPresent()?listaRepository.findById(listaDTO.getIdLista()).get():null;
        if(lista!=null){
            lista.setEstado(listaDTO.getEstado());
            Long idLista=listaRepository.save(lista).getIdLista();
            ListaDTO listaDTONuevo= ListaDTO.builder()
                    .idLista(idLista)
                    .estado(lista.getEstado())
                    .nombre(lista.getNombre()).build();
            return Optional.of(listaDTONuevo);
        }else{
            return Optional.empty();
        }

    }
}
