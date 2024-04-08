package com.eduardo.v2.drogaria.bean;

import ch.qos.logback.core.model.Model;
import com.eduardo.v2.drogaria.domain.Pessoa;
import com.eduardo.v2.drogaria.domain.Usuario;
import com.eduardo.v2.drogaria.jpa.Pessoa.BuscaPessoa;
import com.eduardo.v2.drogaria.jpa.Usuario.BuscaUsuario;
import com.eduardo.v2.drogaria.jpa.Usuario.ListaUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.expression.Messages;

import java.util.Objects;

@Controller
public class UsuarioBean {
    public final BuscaUsuario buscaUsuario;
    private final BuscaPessoa buscaPessoa;
    static Usuario usuarioLogado = null;

    @Autowired
    public UsuarioBean(BuscaUsuario buscaUsuario, BuscaPessoa buscaPessoa) {
        this.buscaUsuario = buscaUsuario;
        this.buscaPessoa = buscaPessoa;
    }

    @GetMapping("drogariaV2/login")
    public String getUsuario(Model model){
        return "login";
    }

    @PostMapping(value = "drogariaV2/login", params = "action=entrar")
    public String entrar(Model model, @RequestParam String cpf, @RequestParam String senha){
        System.out.println("CPF:"+cpf);

        Pessoa pessoa = buscaPessoa.buscarPessoaPorCpf(cpf);
        Usuario usuario = buscaUsuario.buscarUsuarioPorCodigo(pessoa.getId());

        if(Objects.equals(usuario.getSenha(), senha)){
            usuarioLogado = usuario;

            if(Objects.equals(usuario.getTipo(), 'A')){
                return "redirect:/drogariaV2/painelADM/index";
            }
            else if(Objects.equals(usuario.getTipo(), 'C')){
                return "redirect:/drogariaV2/index";
            }
            return "estados";
        }else{
            System.out.println("Senha incorreta!");
        }
        return "login";
    }
}
