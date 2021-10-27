package com.nossaloja.controller.produto;


import com.nossaloja.dto.ProdutoDTO;
import com.nossaloja.model.Produto;
import com.nossaloja.repository.ProdutoRepository;
import com.nossaloja.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produtos")
@ResponseBody
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping
    public ResponseEntity<List<Produto>> getAllProdutos() {
        try {
            List<Produto> produtos = produtoService.findAll();

            if (produtos.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(produtos, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> getProdutoById(@PathVariable("id") long id) {
        Optional<Produto> produto = produtoRepository.findById(id);

        if (produto.isPresent()) {
            return new ResponseEntity<>(produto.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(produces = "application/json")
    @CrossOrigin(origins = "*")
    public ResponseEntity<Produto> createProduto(@RequestBody ProdutoDTO produtoDTO) {
        try {
            Produto produtoResult = this.produtoService.save(produtoDTO);

            return new ResponseEntity<>(produtoResult, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> updateProduto(@PathVariable("id") long id, @RequestBody Produto produto) {
        Optional<Produto> tutorialData = produtoRepository.findById(id);

        if (tutorialData.isPresent()) {
            return new ResponseEntity<>(produtoRepository.save(produto), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteProduto(@PathVariable("id") long id) {
        try {
            produtoRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }




}
