package com.eduardo.v2.drogaria.bean;

import com.eduardo.v2.drogaria.jpa.BuscaEstado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
@Component
@Scope("request")
public class EstadoBean {
    private final BuscaEstado buscaEstado;

    @Autowired
    public EstadoBean(BuscaEstado buscaEstado) {
        this.buscaEstado = buscaEstado;
    }

    public String getNomeEstado() {
        return buscaEstado.buscar().getNome();
    }
}
