package com.eduardo.v2.drogaria.jpa;

import com.eduardo.v2.drogaria.domain.Estado;
import org.springframework.context.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BuscaEstado {
    private final ApplicationContext applicationContext;

    @Autowired
    public BuscaEstado(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    public Estado buscar() {
        try {
            CadastraEstado cadastraEstadoestado = applicationContext.getBean(CadastraEstado.class);
            Estado estado = cadastraEstadoestado.buscar(1L);
            System.out.println(estado.getNome());
            return estado;
        } catch (Exception e) {
            System.out.println("Estado retornou nulo");
            e.printStackTrace();
        }
        return null;
    }
}

