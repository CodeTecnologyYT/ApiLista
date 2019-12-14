package com.pe.apiLista.repository;

import com.pe.apiLista.model.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface TareaRepository extends JpaRepository<Tarea,Long> {

    @Query("from Tarea t where t.lista.idLista=:idLista")
    Set<Tarea> findAllLista(@Param("idLista") Long idLista);
}
