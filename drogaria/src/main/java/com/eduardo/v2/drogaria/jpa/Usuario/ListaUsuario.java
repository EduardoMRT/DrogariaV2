package com.eduardo.v2.drogaria.jpa.Usuario;

import com.eduardo.v2.drogaria.domain.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ListaUsuario {
    private final ApplicationContext applicationContext;

    @Autowired
    public ListaUsuario(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    public List<Usuario> listar(){
        CadastraUsuario cadastraUsuario = applicationContext.getBean(CadastraUsuario.class);
        List<Usuario> usuarios = cadastraUsuario.listar();
        return usuarios;
    }
}
