package com.eduardo.v2.drogaria.ControllerSo;

import com.eduardo.v2.drogaria.domain.Produto;
import org.springframework.ui.Model;
import com.eduardo.v2.drogaria.jpa.Produtos.BuscaProduto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProdutoIndController {

    private final BuscaProduto buscaProduto;
    static Long codProduto;

    @Autowired
    public ProdutoIndController(BuscaProduto buscaProduto) {
        this.buscaProduto = buscaProduto;
    }

    @GetMapping("/drogariaV2/produto")
    public String produto(Model model){
        Produto produto = buscaProduto.buscarProdutoPorCodigo(codProduto);
        model.addAttribute("produtoInd", produto);
        model.addAttribute("codProd", codProduto);
        return "produto";
    }

    @PostMapping("/drogariaV2/prodIndividual")
    public String adcCarrinho(@RequestParam String cod){
        codProduto = Long.parseLong(cod);
        return "redirect:/drogariaV2/produto";
    }


}
