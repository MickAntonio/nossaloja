package com.nossaloja.service.impl;

import com.nossaloja.dto.CompraDTO;
import com.nossaloja.dto.ProdutoQtdDTO;
import com.nossaloja.dto.SalvarCompraDTO;
import com.nossaloja.model.Compra;
import com.nossaloja.model.CompraProduto;
import com.nossaloja.model.Produto;
import com.nossaloja.repository.CompraRepository;
import com.nossaloja.service.CategoriaService;
import com.nossaloja.service.CompraService;
import com.nossaloja.service.ProdutoService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CompraServiceImpl implements CompraService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CompraServiceImpl.class);

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private CompraRepository compraRepository;
    @Autowired
    private ProdutoService produtoService;

    @Override
    public Compra save(SalvarCompraDTO compraDTO) {

        List<CompraProduto> items = new ArrayList<>();

        for (ProdutoQtdDTO item: compraDTO.getProdutos()) {
            Produto produto = this.produtoService.findById(item.getProdutoId());
            items.add(new CompraProduto(produto, item.getQtd()));
        }

        Compra compra = new Compra(compraDTO.getCliente(),
                items
        );

        return this.compraRepository.save(compra);
    }

    @Override
    public Compra findById(long id) {

        Optional<Compra> CompraOpt = compraRepository.findById(id);
        Compra compra=null;

        if (CompraOpt.isPresent()) {
            compra= CompraOpt.get();
        }

        return compra;
    }

    @Override
    public List<Compra> findAll() {
        return compraRepository.findAll();
    }

    @Override
    public CompraDTO convertToDTO(Compra compra) {
        CompraDTO compraDTO = modelMapper.map(compra, CompraDTO.class);
        return compraDTO;
    }

    @Override
    public Compra convertToEntity(CompraDTO compraDTO) {
        Compra compra = modelMapper.map(compraDTO, Compra.class);
        return compra;
    }
}
