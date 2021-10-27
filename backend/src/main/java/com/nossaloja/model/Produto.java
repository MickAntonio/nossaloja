package com.nossaloja.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "TB_PRODUTO")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "preco")
    private Double preco;

    @Column(name = "quatidade_estoque")
    private Integer quatidadeEstoque;

    @Column(name="ultima_actualizacao",columnDefinition = "TIMESTAMP")
    private LocalDateTime ultima_actualizacao;

    @ManyToOne
    private Categoria categoria;

    @Column(name = "imagem")
    private String imagem;

    @JsonIgnore
    @OneToMany(mappedBy = "produto", cascade = CascadeType.ALL)
    private Set<CompraProduto> compraProdutos;
    public Produto(){
    }

    public Produto(long Id){
        this.id=id;
    }

    @PrePersist
    void preInsert() {  this.ultima_actualizacao = LocalDateTime.now();
    }
}
