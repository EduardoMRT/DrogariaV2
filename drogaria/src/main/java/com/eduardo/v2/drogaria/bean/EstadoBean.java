package com.eduardo.v2.drogaria.bean;

import com.eduardo.v2.drogaria.domain.Estado;
import com.eduardo.v2.drogaria.jpa.AdicionaEstado;
import com.eduardo.v2.drogaria.jpa.BuscaEstado;
import jakarta.annotation.ManagedBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EstadoBean {
    private final BuscaEstado buscaEstado;
    private  final AdicionaEstado adicionaEstado;

    @Autowired
    public EstadoBean(BuscaEstado buscaEstado, AdicionaEstado adicionaEstado) {
        this.buscaEstado = buscaEstado;
        this.adicionaEstado = adicionaEstado;
    }

    @GetMapping("/teste123")
    public String getEstado(Model model) {
        Estado estado = buscaEstado.buscar(1L);
        model.addAttribute("estado", estado);
        return "estados"; //nesse caso seria o mesmo que estado.html por estar na pasta templates
    }

    @PostMapping ("/teste1234")
    public String adcEstado(Model model, String nome, String sigla){
        Estado estado = adicionaEstado.adicionar(nome, sigla);
        model.addAttribute("estado", estado);
        return "estados";
    }
}
