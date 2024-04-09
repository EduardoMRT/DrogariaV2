package com.eduardo.v2.drogaria.ControllerSo;

import com.eduardo.v2.drogaria.domain.Produto;
import com.eduardo.v2.drogaria.jpa.Produtos.BuscaProduto;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CarrinhoController {

    Double valorTotal;
    Integer qtddeProdutos;
    static List<Produto> produtoList;
    private final BuscaProduto buscaProduto;

    @Autowired
    private HttpServletRequest request;

    @Autowired
    public CarrinhoController(BuscaProduto buscaProduto) {
        this.buscaProduto = buscaProduto;
    }

    @GetMapping("/drogariaV2/carrinho")
    public String buscaCarrinho(Model model){
        valorTotal = 0.00;

        model.addAttribute("produtos", produtoList);

        for(Produto produto : produtoList){
            valorTotal += (produto.getPreco() * produto.getQtdUsuario());
        }

        model.addAttribute("qtddeProdutos", qtddeProdutos);
        DecimalFormat df = new DecimalFormat("#.##");
        String valorTotalString = df.format(valorTotal);
        valorTotalString = valorTotalString.replace(",",".");
        valorTotal = Double.parseDouble(valorTotalString);
        model.addAttribute("valorTotal", valorTotal);
        return "carrinho";
    }

    @PostMapping( "/drogariaV2/adcProdCarrinho")
    public String adcProdCarrinho(@RequestParam String quantidadeUsuario, @RequestParam String cod){
        if (produtoList == null) {
            produtoList = new ArrayList<>();
        }
        Produto produto = buscaProduto.buscarProdutoPorCodigo(Long.parseLong(cod));
        DecimalFormat df = new DecimalFormat("#.##");
        String precoString = df.format(produto.getPreco());
        precoString = precoString.replace(",",".");
        produto.setPreco(Double.parseDouble(precoString));
        produto.setQtdUsuario(Integer.parseInt(quantidadeUsuario));
        produtoList.add(produto);
        qtddeProdutos = 0;
        for(Produto produto1 : produtoList){
            qtddeProdutos++;
            produto.setQtdProdCarrinho(qtddeProdutos);
        }
        request.getSession().setAttribute("qtddeProdutos", qtddeProdutos);
        return "redirect:/drogariaV2/produto";
    }
}
