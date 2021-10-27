package com.nossaloja.service;

import com.nossaloja.dto.ProdutoDTO;
import com.nossaloja.model.Produto;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProdutoService {
    Produto save(ProdutoDTO ProdutoDTO);
    public Produto findById(long id);
    List<Produto> findAll();

    ProdutoDTO convertToDTO(Produto factura);
    Produto convertToEntity(ProdutoDTO facturaDTO);
}
