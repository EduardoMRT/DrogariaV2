package com.eduardo.v2.drogaria.bean;

import com.eduardo.v2.drogaria.jpa.BuscaEstado;
import jakarta.annotation.ManagedBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
@Component
public class EstadoBean {
    private final BuscaEstado buscaEstado;

    @Autowired
    public EstadoBean(BuscaEstado buscaEstado) {
        this.buscaEstado = buscaEstado;
    }

    public String getNomeEstado() {
        System.out.println("entrou");
        return buscaEstado.buscar().getNome();
    }
}
