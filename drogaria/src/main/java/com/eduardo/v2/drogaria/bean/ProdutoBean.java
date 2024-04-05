package com.eduardo.v2.drogaria.bean;

import org.springframework.ui.Model;
import com.eduardo.v2.drogaria.domain.Produto;
import com.eduardo.v2.drogaria.jpa.Produtos.AdicionarProduto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProdutoBean {
    private final AdicionarProduto adicionarProduto;

    @Autowired
    public ProdutoBean(AdicionarProduto adicionarProduto) {
        this.adicionarProduto = adicionarProduto;
    }

    @GetMapping("/drogariaV2/painelADM/produtos/adcProdutos")
    public String listar(Model model){

        return "painelADM/adcProdutos";
    }
    @PostMapping("/drogariaV2/painelADM/produtos/adcProdutos")
    public String adicionar(Model model, String nome, Integer quantidade, double preco, String descricao){
        Produto produto = adicionarProduto.adicionar(nome, quantidade, preco, descricao);
        model.addAttribute("produtoAdc", produto);
        return "painelADM/adcProdutos";
    }
}
