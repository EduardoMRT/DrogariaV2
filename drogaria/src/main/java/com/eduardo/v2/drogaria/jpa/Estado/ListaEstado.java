package com.eduardo.v2.drogaria.jpa.Estado;

import com.eduardo.v2.drogaria.domain.Estado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ListaEstado {
    private final ApplicationContext applicationContext;

    @Autowired
    public ListaEstado(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    public List<Estado> listar(){
        CadastraEstado cadastraEstadoestado = applicationContext.getBean(CadastraEstado.class);
        List<Estado> estados = cadastraEstadoestado.listar();
        return estados;
    }
}
