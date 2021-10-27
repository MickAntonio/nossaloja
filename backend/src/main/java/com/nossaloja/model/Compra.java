package com.nossaloja.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.List;

@Data
@Entity
@Table(name = "TB_COMPRA")
public class Compra {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    //@ManyToOne
    //private Cliente cliente;

    @Column(name="data",columnDefinition = "TIMESTAMP")
    private LocalDateTime data;


    @OneToMany(mappedBy = "compra", cascade = CascadeType.ALL)
    private Set<CompraProduto> compraProdutos;

    public Compra(Cliente name, List<CompraProduto> compraProdutos) {
       // this.cliente = name;
        for(CompraProduto compraProduto : compraProdutos){
            compraProduto.setCompra(this);
            compraProduto.setProduto(compraProduto.getProduto());
            compraProduto.setQuantidade(compraProduto.getQuantidade());
        }

        this.compraProdutos = new HashSet<>(compraProdutos);
    //Stream.of(compraProdutos).collect(Collectors.toSet());
    }

    public Compra() {

    }
}
