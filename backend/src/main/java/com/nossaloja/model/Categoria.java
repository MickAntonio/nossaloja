package com.nossaloja.model;


import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Table(name = "TB_CATEGORIA")
@AllArgsConstructor
@NoArgsConstructor
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "descricao")
    private String descricao;

}
