package com.pe.apiLista.service.impl;

import com.pe.apiLista.dto.model.TareaDTO;
import com.pe.apiLista.model.Lista;
import com.pe.apiLista.model.Tarea;
import com.pe.apiLista.repository.ListaRepository;
import com.pe.apiLista.repository.TareaRepository;
import com.pe.apiLista.service.TareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TareaServiceImpl implements TareaService {

    @Autowired
    ListaRepository listaRepository;

    @Autowired
    TareaRepository tareaRepository;


    public Optional<TareaDTO> actualizarEstadoTarea(TareaDTO tareaDTO){
        Tarea tarea =( tareaRepository.findById(tareaDTO.getIdTarea()).isPresent() ? tareaRepository.findById(tareaDTO.getIdTarea()).get() : null);
        if(tarea!=null){
            tarea.setEstado(tareaDTO.getEstado());
            tareaRepository.save(tarea);
            TareaDTO tareaNew=tareaDTO.builder()
                    .fechaVencimiento(tarea.getFechaVencimiento())
                    .idLista(tarea.getLista().getIdLista())
                    .estado(tareaDTO.getEstado())
                    .idTarea(tarea.getIdTarea()).build();
            return Optional.of(tareaDTO);
        }else{
            return Optional.empty();
        }
    }

    public Optional<List<TareaDTO>> listarTareas(Long idLista){
        List<Tarea> listaTareas= new ArrayList<>();
        tareaRepository.findAllLista(idLista).iterator().forEachRemaining(listaTareas::add);
        List<TareaDTO> tareasDTOS=listaTareas.stream().map(task->{
            TareaDTO tareasDTO = TareaDTO.builder()
                    .estado(task.getEstado())
                    .idTarea(task.getIdTarea())
                    .fechaVencimiento(task.getFechaVencimiento())
                    .nombre(task.getNombre())
                    .idLista(task.getLista().getIdLista())
                    .build();
            return tareasDTO;
        }).collect(Collectors.toList());

        return Optional.of(tareasDTOS);
    }

    public Optional<TareaDTO> agregarTarea(TareaDTO tareaDTO){
        Lista lista = listaRepository.findById(tareaDTO.getIdLista()).isPresent()? listaRepository.findById(tareaDTO.getIdLista()).get():null;
        if(lista!=null){
            Tarea tarea = Tarea.builder().lista(lista).nombre(tareaDTO.getNombre()).fechaVencimiento(tareaDTO.getFechaVencimiento()).build();
            Long idTarea=tareaRepository.save(tarea).getIdTarea();
            TareaDTO tareaDTONew=TareaDTO.builder().nombre(tareaDTO.getNombre())
                    .idTarea(idTarea)
                    .idLista(tarea.getLista().getIdLista())
                    .fechaVencimiento(tareaDTO.getFechaVencimiento()).build();
            return Optional.of(tareaDTONew);
        }else{
            return Optional.empty();
        }
    }
}
