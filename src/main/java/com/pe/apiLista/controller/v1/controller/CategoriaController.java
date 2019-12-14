package com.pe.apiLista.controller.v1.controller;

import com.pe.apiLista.model.Categoria;
import com.pe.apiLista.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value="categorias")
public class CategoriaController {

    @Autowired
    CategoriaRepository categoriaRepository;

    @GetMapping(value="/")
    public ResponseEntity allCategory(){
        System.out.println("listar categorias");
        List<Categoria> listaCategoria= new ArrayList<>();
        categoriaRepository.findAll().iterator().forEachRemaining(listaCategoria::add);
        return ResponseEntity.ok(listaCategoria);
    }

}
