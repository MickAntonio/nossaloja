package com.nossaloja.service.impl;

import com.nossaloja.dto.ProdutoDTO;
import com.nossaloja.model.Produto;
import com.nossaloja.repository.ProdutoRepository;
import com.nossaloja.service.CategoriaService;
import com.nossaloja.service.ProdutoService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProdutoServiceImpl.class);

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ProdutoRepository produtoRepository;
    @Autowired
    private CategoriaService categoriaService;

    @Override
    public Produto save(ProdutoDTO produtoDTO) {
        return this.produtoRepository.save(this.convertToEntity(produtoDTO));
    }

    @Override
    public Produto findById(long id) {

        Optional<Produto> ProdutoOpt = produtoRepository.findById(id);
        Produto produto=null;

        if (ProdutoOpt.isPresent()) {
            produto= ProdutoOpt.get();
        }

        return produto;
    }

    @Override
    public List<Produto> findAll() {
        return produtoRepository.findAll();
    }

    @Override
    public ProdutoDTO convertToDTO(Produto produto) {
        ProdutoDTO produtoDTO = modelMapper.map(produto, ProdutoDTO.class);
        return produtoDTO;
    }

    @Override
    public Produto convertToEntity(ProdutoDTO produtoDTO) {
        Produto produto = modelMapper.map(produtoDTO, Produto.class);
        produto.setCategoria(this.categoriaService.findById(produtoDTO.getCategoria()));

        return produto;
    }
}
