package com.eduardo.v2.drogaria.jpa.Estado;

import com.eduardo.v2.drogaria.domain.Estado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class AdicionaEstado {
    private final ApplicationContext applicationContext;

    @Autowired
    public AdicionaEstado(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    public Estado adicionar(String nome, String sigla){
        try {
            Estado estado = new Estado();
            estado.setNome(nome);
            estado.setSigla(sigla);

            CadastraEstado cadastraEstadoestado = applicationContext.getBean(CadastraEstado.class);
            cadastraEstadoestado.adicionar(estado);
            return estado;
        }catch (RuntimeException e){
            System.out.println("Ocorreu um erro ao tentar adicionar o Estado");
            e.printStackTrace();
        }
        return null;
    }
}
