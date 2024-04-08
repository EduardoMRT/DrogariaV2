package com.eduardo.v2.drogaria.ControllerSo;

import com.eduardo.v2.drogaria.domain.Produto;
import com.eduardo.v2.drogaria.jpa.Produtos.BuscaProduto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CarrinhoController {
    public List<Produto> produtoList;
    private final BuscaProduto buscaProduto;

    @Autowired
    public CarrinhoController(BuscaProduto buscaProduto) {
        this.buscaProduto = buscaProduto;
    }

    @GetMapping("/drogariaV2/carrinho")
    public String buscaCarrinho(Model model){
        return "carrinho";
    }

    @PostMapping( "/drogariaV2/adcProdCarrinho")
    public String adcProdCarrinho(@RequestParam String quantidadeUsuario, @RequestParam String cod){
        if (produtoList == null) {
            produtoList = new ArrayList<>();
        }
        Produto produto = buscaProduto.buscarProdutoPorCodigo(Long.parseLong(cod));
        produtoList.add(produto);

        System.out.println("Teste:"+quantidadeUsuario+"Cod:"+cod);
        return "redirect:/drogariaV2/produto";
    }
}
