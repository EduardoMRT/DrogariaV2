package com.eduardo.v2.drogaria.ControllerSo;

import com.eduardo.v2.drogaria.bean.UsuarioBean;
import com.eduardo.v2.drogaria.domain.Produto;
import com.eduardo.v2.drogaria.domain.Usuario;
import com.eduardo.v2.drogaria.jpa.Produtos.BuscaProduto;
import com.eduardo.v2.drogaria.jpa.Produtos.ExcluiProduto;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CarrinhoController {

    Double valorTotal;
    Integer qtddeProdutos;
    static List<Produto> produtoList;
    private final BuscaProduto buscaProduto;
    private final ExcluiProduto excluiProduto;

    @Autowired
    private HttpServletRequest request;

    @Autowired
    public CarrinhoController(BuscaProduto buscaProduto, ExcluiProduto excluiProduto) {
        this.buscaProduto = buscaProduto;
        this.excluiProduto = excluiProduto;
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

    @PostMapping("/drogariaV2/removerProdCarrinho")
    public String removerProdCarrinho(@RequestParam String cod){
        produtoList.removeIf(produto -> produto.getCod_produto().equals(Long.parseLong(cod)));
        request.getSession().setAttribute("qtddeProdutos", qtddeProdutos - 1);
        return "redirect:/drogariaV2/carrinho";
    }


    @PostMapping( "/drogariaV2/adcProdCarrinho")
    public String adcProdCarrinho(@RequestParam String quantidadeUsuario, @RequestParam String cod){
        if (produtoList == null) {
            produtoList = new ArrayList<>();
        }

        Produto produto = buscaProduto.buscarProdutoPorCodigo(Long.parseLong(cod));

        for(Produto prod : produtoList){
            if (prod.getCod_produto().equals(produto.getCod_produto())) {
                prod.setQtdUsuario(prod.getQtdUsuario() + Integer.parseInt(quantidadeUsuario));
                return "redirect:/drogariaV2/produto";
            }
        }

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

    @PostMapping("/drogariaV2/fazerPedido")
    public String fazerPedido(){
        StringBuilder cabecalhoMensagem = new StringBuilder();
                cabecalhoMensagem.append("Drogaria MultiFarma\n Pedido: ");

        String infoPessoa = "";
        StringBuilder mensagem = new StringBuilder();
        String finalMensagem = "\nObrigado por comprar na Drogaria Multifarma!";
        if(produtoList != null) {
            for (Produto produto : produtoList) {
                mensagem.append("\n\n Produto: ").append(produto.getNome()).append("\n Quantidade: ").append(produto.getQtdProdCarrinho()).append("\n Preço: R$").append(produto.getPreco()).append("\n Preço Total dos Produtos: R$").append(produto.getPreco() * produto.getQtdProdCarrinho());
            }
        }
        String mensagemCodificada = URLEncoder.encode(mensagem.toString(), StandardCharsets.UTF_8);
        return "redirect:https://wa.me/{number}?text="+cabecalhoMensagem.append(mensagemCodificada);
    }
}
