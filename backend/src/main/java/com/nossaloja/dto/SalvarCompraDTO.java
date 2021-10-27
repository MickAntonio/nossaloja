package com.nossaloja.dto;

import com.nossaloja.model.Cliente;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class SalvarCompraDTO {
    private long id;
    private Cliente cliente;
    private LocalDateTime data;
    private List<ProdutoQtdDTO> produtos;
}
