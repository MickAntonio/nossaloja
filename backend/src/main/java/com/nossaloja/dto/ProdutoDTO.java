package com.nossaloja.dto;

import com.nossaloja.model.Categoria;
import lombok.Data;

@Data
public class ProdutoDTO {
    private long id;
    private String nome;
    private String descricao;
    private Double preco;
    private Integer quatidadeEstoque;
    private Long categoria;
    private String imagem;

}
