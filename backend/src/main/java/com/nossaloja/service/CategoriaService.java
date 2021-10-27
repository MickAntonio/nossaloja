package com.nossaloja.service;

import com.nossaloja.dto.CategoriaDTO;
import com.nossaloja.model.Categoria;
import com.nossaloja.model.Produto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoriaService {
    Categoria save(CategoriaDTO categoriaDTO);
    public Categoria findById(long id);
    List<Categoria> findAll();

    CategoriaDTO convertToDTO(Categoria categoria);
    Categoria convertToEntity(CategoriaDTO categoria);
}
