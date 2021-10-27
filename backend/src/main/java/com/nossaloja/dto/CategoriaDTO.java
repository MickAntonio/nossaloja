package com.nossaloja.dto;

import lombok.Data;

import javax.persistence.Column;
@Data
public class CategoriaDTO {
    private long id;
    private String nome;
    private String descricao;
}
