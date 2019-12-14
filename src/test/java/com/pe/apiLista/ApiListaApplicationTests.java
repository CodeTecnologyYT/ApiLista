package com.pe.apiLista;

import com.pe.apiLista.model.Categoria;
import com.pe.apiLista.repository.CategoriaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApiListaApplicationTests {

	@Autowired
	CategoriaRepository categoriaRepository;

	@Test
	void cargarData(){

		categoriaRepository.save(new Categoria("deportes"));

	}

}
