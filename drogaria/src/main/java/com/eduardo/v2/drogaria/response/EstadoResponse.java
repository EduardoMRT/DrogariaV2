package com.eduardo.v2.drogaria.response;

import com.eduardo.v2.drogaria.domain.Estado;

public record EstadoResponse(Long codigo, String sigla, String nome) {
    public EstadoResponse(Estado estado){
        this(estado.getCodigo(), estado.getSigla(), estado.getNome());
    }
}
