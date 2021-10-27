package com.nossaloja.dto;

import com.nossaloja.model.Cliente;
import com.nossaloja.model.CompraProduto;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

import java.util.List;

@Data
public class CompraDTO {
    private long id;
    private Cliente cliente;
    private LocalDateTime data;
    private CompraProduto CompraProduto;
}
