package com.pe.apiLista.controller.v1.controller;

import com.pe.apiLista.controller.v1.request.ListaRequest;
import com.pe.apiLista.controller.v1.request.TareaRequest;
import com.pe.apiLista.dto.model.ListaDTO;
import com.pe.apiLista.dto.model.TareaDTO;
import com.pe.apiLista.exception.EntityNotFoundException;
import com.pe.apiLista.service.ListaService;
import com.pe.apiLista.service.TareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
@RestController
@RequestMapping(value = "listas")
public class ListaController {

    @Autowired
    ListaService listaService;

    @Autowired
    TareaService tareaService;


    private static final int  ESTADO_ELIMINADO = 3;

    @PostMapping(value = "/")
    public ResponseEntity addList(@RequestBody @Valid ListaRequest listaRequest){
        ListaDTO listaDTO = ListaDTO.builder()
                .nombre(listaRequest.getNombre())
                .idCategoria(listaRequest.getIdCategoria()).build();

        return listaService.agregarLista(listaDTO).map(listaDTO1 -> ResponseEntity.ok().body(listaDTO1))
                .orElseThrow(()-> new EntityNotFoundException(ListaDTO.class,"idCategoria",listaRequest.getIdCategoria().toString()));

    }
    @GetMapping(value="/")
    public ResponseEntity allList(){
        return listaService.listarLista().map(listaDTOS -> ResponseEntity.ok().body(listaDTOS))
                .orElseThrow(()-> new EntityNotFoundException(ListaDTO.class,"lista","todas"));
    }

    @PutMapping(value="/{idLista}")
    public ResponseEntity deleteList(@PathVariable(name="idLista") Long idLista){
        ListaDTO tareaDTO= ListaDTO.builder().idLista(idLista).estado(ESTADO_ELIMINADO).build();
        return listaService.actualizarEstado(tareaDTO).map(listaDTO -> new ResponseEntity<ListaDTO>(listaDTO,HttpStatus.CREATED))
                .orElseThrow(()-> new EntityNotFoundException(ListaDTO.class,"idLista",idLista.toString()));
    }


    @PostMapping(value="/{idLista}/tareas/")
    public ResponseEntity addTask(@PathVariable(name="idLista") Long idLista,@RequestBody @Valid TareaRequest tareaRequest){
        TareaDTO tareaDTO= TareaDTO.builder().idLista(idLista)
                .nombre(tareaRequest.getNombre())
                .fechaVencimiento(tareaRequest.getFechaVencimiento())
                .build();
        return tareaService.agregarTarea(tareaDTO).map(tareaDTO1 -> new ResponseEntity<TareaDTO>(tareaDTO1,HttpStatus.CREATED))
                .orElseThrow(()-> new EntityNotFoundException(ListaDTO.class,"idLista",idLista.toString()));
    }

    @GetMapping(value="/{idLista}/tareas/")
    public ResponseEntity allTask(@PathVariable(name="idLista") Long idLista){
        return tareaService.listarTareas(idLista).map(tareasDTOS -> ResponseEntity.ok().body(tareasDTOS))
                .orElseThrow(()-> new EntityNotFoundException(ListaDTO.class,"tareas","todas"));
    }



    @PutMapping(value = "/{idLista}/tareas/{idTarea}")
    public ResponseEntity deleteTask(@PathVariable(name="idLista") Long idLista, @PathVariable(name = "idTarea") Long idTarea){
        TareaDTO tareaDTO= TareaDTO.builder().idTarea(idTarea).estado(ESTADO_ELIMINADO).build();
        return tareaService.actualizarEstadoTarea(tareaDTO).map(tareaDTO1 -> ResponseEntity.ok().body(tareaDTO))
                .orElseThrow(()-> new EntityNotFoundException(TareaDTO.class,"idTareas",idTarea.toString()));
    }
}
