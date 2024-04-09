package com.eduardo.v2.drogaria.domain;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Table(name = "produto")
@Entity(name = "produto")
@Getter
@Setter
@EqualsAndHashCode(of = "cod_produto")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cod_produto;
    private String nome;
    private Integer quantidade;
    private double preco;
    private String descricao;

//    USADO APENAS PARA REALIZAR A MULT NO CARRINHO
    private Integer qtdUsuario;
    private Integer qtdProdCarrinho;
}
