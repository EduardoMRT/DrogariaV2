package com.eduardo.v2.drogaria.domain;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "estado")
@Entity(name = "estado")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Estado{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    private String sigla;
    private String nome;
}