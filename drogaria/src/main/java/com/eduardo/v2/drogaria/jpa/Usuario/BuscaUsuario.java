package com.eduardo.v2.drogaria.jpa.Usuario;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.eduardo.v2.drogaria.domain.Pessoa;
import com.eduardo.v2.drogaria.domain.Usuario;
@Component
public class BuscaUsuario {
    private final ApplicationContext applicationContext;
    @Autowired
    public BuscaUsuario(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    public Usuario buscarUsuarioPorCodigo(Long cod){
        try{
            CadastraUsuario cadastraUsuario = applicationContext.getBean(CadastraUsuario.class);
            Usuario usuario = cadastraUsuario.buscar(1L);
            System.out.println("Nome do Usuario:"+usuario.getPessoa().getNome());
            return usuario;
        }catch (RuntimeException e){
            System.out.println("Ocorreu um erro ao tentar buscar o usuário!");
            e.printStackTrace();
            return null;
        }
    }

    public Usuario buscarUsuarioPorCpf(String cpf){
        try{
            CadastraUsuario cadastraUsuario = applicationContext.getBean(CadastraUsuario.class);
            Pessoa pessoa = new Pessoa();
            Usuario usuario = cadastraUsuario.buscar(pessoa.getCpf());
            System.out.println(usuario.getPessoa().getNome());
            return usuario;
        }catch (RuntimeException e){
            System.out.println("Ocorreu um erro ao tentar buscar o usuário!");
            e.printStackTrace();
            return null;
        }
    }
}
