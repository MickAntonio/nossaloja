package com.nossaloja.controller.compras;

import com.nossaloja.dto.CompraDTO;
import com.nossaloja.dto.SalvarCompraDTO;
import com.nossaloja.model.Compra;
import com.nossaloja.repository.CompraRepository;
import com.nossaloja.service.CompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/compras")
@ResponseBody
public class CompraController {
    @Autowired
    private CompraService compraService;

    @Autowired
    private CompraRepository compraRepository;

    @GetMapping
    public ResponseEntity<List<Compra>> getAllCompras() {
        try {
            List<Compra> compras = compraService.findAll();

            if (compras.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(compras, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<Compra> getCompraById(@PathVariable("id") long id) {
        Optional<Compra> compra = compraRepository.findById(id);

        if (compra.isPresent()) {

            return new ResponseEntity<>(compra.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(produces = "application/json")
    @CrossOrigin(origins = "*")
    public ResponseEntity<Object> createCompra(@RequestBody SalvarCompraDTO compraDTO) {
        try {
            Compra compraResult = this.compraService.save(compraDTO);

            return new ResponseEntity<>(compraResult, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Compra> updateCompra(@PathVariable("id") long id, @RequestBody Compra compra) {
        Optional<Compra> tutorialData = compraRepository.findById(id);

        if (tutorialData.isPresent()) {
            return new ResponseEntity<>(compraRepository.save(compra), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteCompra(@PathVariable("id") long id) {
        try {
            compraRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



}
