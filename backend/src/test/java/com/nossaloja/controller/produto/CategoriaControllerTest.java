package com.nossaloja.controller.produto;

import com.nossaloja.model.Categoria;
import com.nossaloja.repository.CategoriaRepository;
import com.nossaloja.service.CategoriaService;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class CategoriaControllerTest {

    @Autowired
    private CategoriaService categoriaService;

    @MockBean
    private CategoriaRepository categoriaRepository;

    @Test
    void getAllCategorias() {
        when(this.categoriaRepository.findAll())
                .thenReturn(Stream.of(new Categoria(1L, "Vestuário", "Novo vestuário"),
                        new Categoria(2L, "Calçados", "Novos calçados"))
                        .collect(Collectors.toList()));

        assertEquals(2, categoriaService.findAll().size());
    }

    @Test
    void getCategoriaById() {
    }

    @Test
    void createCategoria() {
    }
}