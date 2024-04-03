package com.eduardo.v2.drogaria.jpa;

import com.eduardo.v2.drogaria.domain.Estado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class ExcluiEstado {
    private final ApplicationContext applicationContext;

    @Autowired
    public ExcluiEstado(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    public Estado remover(Estado estado) {
        try {
            CadastraEstado cadastraEstadoestado = applicationContext.getBean(CadastraEstado.class);
            cadastraEstadoestado.remover(estado);
            return estado;
        } catch (RuntimeException e) {
            System.out.println("Ocorreu um erro ao tentar remover o Estado");
            e.printStackTrace();
        }
        return null;
    }
}
