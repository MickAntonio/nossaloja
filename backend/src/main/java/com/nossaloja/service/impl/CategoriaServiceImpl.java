package com.nossaloja.service.impl;

import com.nossaloja.dto.CategoriaDTO;
import com.nossaloja.dto.ProdutoDTO;
import com.nossaloja.model.Categoria;
import com.nossaloja.model.Produto;
import com.nossaloja.repository.CategoriaRepository;
import com.nossaloja.repository.ProdutoRepository;
import com.nossaloja.service.CategoriaService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProdutoServiceImpl.class);

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public Categoria save(CategoriaDTO categoriaDTO) {
        return this.categoriaRepository.save(this.convertToEntity(categoriaDTO));
    }

    @Override
    public Categoria findById(long id) {

        Optional<Categoria> CategoriaOpt = this.categoriaRepository.findById(id);
        Categoria categoria=null;

        if (CategoriaOpt.isPresent()) {
            categoria= CategoriaOpt.get();
        }

        return categoria;
    }

    @Override
    public List<Categoria> findAll() {
        return this.categoriaRepository.findAll();
    }

    @Override
    public CategoriaDTO convertToDTO(Categoria categoria) {
        CategoriaDTO categoriaDTO = modelMapper.map(categoria, CategoriaDTO.class);
        return categoriaDTO;
    }

    @Override
    public Categoria convertToEntity(CategoriaDTO categoriaDTO) {
        Categoria categoria = modelMapper.map(categoriaDTO, Categoria.class);
        return categoria;
    }
}
