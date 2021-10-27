package com.nossaloja.service;

import com.nossaloja.dto.CompraDTO;
import com.nossaloja.dto.SalvarCompraDTO;
import com.nossaloja.model.Compra;

import java.util.List;

public interface CompraService {
    Compra save(SalvarCompraDTO CompraDTO);
    public Compra findById(long id);
    List<Compra> findAll();

    CompraDTO convertToDTO(Compra factura);
    Compra convertToEntity(CompraDTO facturaDTO);
}
