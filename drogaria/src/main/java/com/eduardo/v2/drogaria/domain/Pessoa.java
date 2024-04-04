package com.eduardo.v2.drogaria.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Table(name = "pessoa")
@Entity(name = "pessoa")
@Getter
@Setter
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String nome;

    @Column(nullable = false, length = 14)
    private String cpf;

    @Column(nullable = false, length = 12)
    private String rg;

    @Column(nullable = false, length = 100)
    private String rua;

    @Column(nullable = false)
    private Short numero;

    @Column(nullable = false, length = 30)
    private String bairro;

    @Column(nullable = false, length = 10)
    private String cep;

    @Column(length = 10)
    private String complemento;

    @Column(nullable = false, length = 13)
    private String telefone;

    @Column(nullable = false, length = 14)
    private String celular;

    @Column(nullable = false, length = 100)
    private String email;
}
