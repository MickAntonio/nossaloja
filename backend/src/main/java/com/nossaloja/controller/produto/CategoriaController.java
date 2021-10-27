package com.nossaloja.controller.produto;

import com.nossaloja.dto.CategoriaDTO;
import com.nossaloja.model.Categoria;
import com.nossaloja.repository.CategoriaRepository;
import com.nossaloja.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categorias")
@ResponseBody
public class CategoriaController {

        @Autowired
        private CategoriaService categoriaService;

        @Autowired
        private CategoriaRepository categoriaRepository;

        @GetMapping
        public ResponseEntity<List<Categoria>> getAllCategorias() {
            try {
                List<Categoria> categorias = categoriaService.findAll();

                if (categorias.isEmpty()) {
                    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                }
                return new ResponseEntity<>(categorias, HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        @GetMapping("/{id}")
        public ResponseEntity<Categoria> getCategoriaById(@PathVariable("id") long id) {
            Optional<Categoria> categoria = categoriaRepository.findById(id);

            if (categoria.isPresent()) {

                return new ResponseEntity<>(categoria.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }

        @PostMapping(produces = "application/json")
        @CrossOrigin(origins = "*")
        public ResponseEntity<Categoria> createCategoria(@RequestBody CategoriaDTO categoriaDTO) {
            try {
                Categoria categoriaResult = this.categoriaService.save(categoriaDTO);

                return new ResponseEntity<>(categoriaResult, HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        @PutMapping("/{id}")
        public ResponseEntity<Categoria> updateCategoria(@PathVariable("id") long id, @RequestBody Categoria categoria) {
            Optional<Categoria> tutorialData = categoriaRepository.findById(id);

            if (tutorialData.isPresent()) {
                return new ResponseEntity<>(categoriaRepository.save(categoria), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<HttpStatus> deleteCategoria(@PathVariable("id") long id) {
            try {
                categoriaRepository.deleteById(id);
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }




    }
