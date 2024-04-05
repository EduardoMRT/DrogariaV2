package com.eduardo.v2.drogaria.ControllerSo;

import org.springframework.ui.Model;
import com.eduardo.v2.drogaria.domain.Produto;
import com.eduardo.v2.drogaria.jpa.Produtos.BuscaProduto;
import com.eduardo.v2.drogaria.jpa.Produtos.ListarProduto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class indexController {
    public final ListarProduto listarProduto;

    @Autowired
    public indexController(ListarProduto listarProduto) {
        this.listarProduto = listarProduto;
    }

    @GetMapping("/drogariaV2/index")
    public String retornaProduto(Model model){
        Produto produto = new Produto();
        model.addAttribute("produto", produto);
        List<Produto> produtos = listarProduto.listar();
        model.addAttribute("produtos", produtos);
        return "index";
    }
}
