package com.eduardo.v2.drogaria.bean;

import ch.qos.logback.core.model.Model;
import com.eduardo.v2.drogaria.domain.Usuario;
import com.eduardo.v2.drogaria.jpa.Usuario.BuscaUsuario;
import com.eduardo.v2.drogaria.jpa.Usuario.ListaUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Objects;

@Controller
public class UsuarioBean {
    public final BuscaUsuario buscaUsuario;
    private final ListaUsuario listaUsuario;
    static Usuario usuarioLogado = null;

    @Autowired
    public UsuarioBean(BuscaUsuario buscaUsuario, ListaUsuario listaUsuario) {
        this.buscaUsuario = buscaUsuario;
        this.listaUsuario = listaUsuario;
    }

    @GetMapping("drogariaV2/login")
    public String getUsuario(Model model){
        return "login";
    }

    @PostMapping(value = "drogariaV2/login", params = "action=entrar")
    public String entrar(Model model, String cpf, String senha){
        System.out.println("CPF:"+cpf);
        Usuario usuario = buscaUsuario.buscarUsuarioPorCodigo(1L);

        System.out.println(usuario.getPessoa().getNome());
       /* if(Objects.equals(usuario1.getSenha(), senha)){
            System.out.println("Usuario "+usuario1.getPessoa().getNome()+" logado com sucesso!");
            usuarioLogado = usuario1;
        }else{
            System.out.println("Senha incorreta");
        }*/
        /*List<Usuario> usuarioList = listaUsuario.listar();
        for(Usuario usuario : usuarioList){}*/
        return "login";
    }
}
