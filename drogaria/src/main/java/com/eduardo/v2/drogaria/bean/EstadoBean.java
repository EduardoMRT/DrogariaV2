package com.eduardo.v2.drogaria.bean;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.eduardo.v2.drogaria.domain.Estado;
import com.eduardo.v2.drogaria.jpa.AdicionaEstado;
import com.eduardo.v2.drogaria.jpa.BuscaEstado;
import com.eduardo.v2.drogaria.jpa.ExcluiEstado;
import com.eduardo.v2.drogaria.jpa.ListaEstado;

@Controller
public class EstadoBean {
    private final BuscaEstado buscaEstado;
    private  final AdicionaEstado adicionaEstado;
    private  final ListaEstado listaEstado;
    private  final ExcluiEstado excluiEstado;

    @Autowired
    public EstadoBean(BuscaEstado buscaEstado, AdicionaEstado adicionaEstado, ListaEstado listaEstado, ExcluiEstado excluiEstado) {
        this.buscaEstado = buscaEstado;
        this.adicionaEstado = adicionaEstado;
        this.listaEstado = listaEstado;
        this.excluiEstado = excluiEstado;
    }

    @GetMapping("/estadosADM")
    public String getEstado(Model model) {
        Estado estado = buscaEstado.buscar(1L);
        model.addAttribute("estado", estado);

        List<Estado> estadosList = listaEstado.listar();
        model.addAttribute("estadosList", estadosList);

        Estado estado1 = new Estado();
        model.addAttribute("estado1", estado1);

        return "estados"; //nesse caso seria o mesmo que estado.html por estar na pasta templates
    }

    @PostMapping ("/estadosADM")
    public String adcEstado(Model model, String nome, String sigla){
        Estado estado = adicionaEstado.adicionar(nome, sigla);
        model.addAttribute("estado", estado);
        getEstado(model);
        return "estados";
    }

    @PostMapping("/estadosADM/deletar")
    public String removerEstado(Model model, String codigo){
        Long cod = Long.parseLong(codigo);
        Estado estado = buscaEstado.buscar(cod);
        excluiEstado.remover(estado);
        return "estados";
    }
}
