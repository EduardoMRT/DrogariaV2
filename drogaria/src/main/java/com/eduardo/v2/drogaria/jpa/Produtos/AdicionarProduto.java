package com.eduardo.v2.drogaria.jpa.Produtos;

import com.eduardo.v2.drogaria.domain.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class AdicionarProduto {
    private final ApplicationContext applicationContext;

    @Autowired
    public AdicionarProduto(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    //Inserir fabricante depois
    public Produto adicionar(String nome, Integer quantidade, double preco, String descricao){

        try{
            Produto produto = new Produto();
            produto.setNome(nome);
            produto.setQuantidade(quantidade);
            produto.setPreco(preco);
            produto.setDescricao(descricao);
            ProdutoJPA produtoJPA = applicationContext.getBean(ProdutoJPA.class);
            produtoJPA.adicionar(produto);
            return produto;
        }catch (RuntimeException e){
            e.printStackTrace();
            System.out.println("Ocorreu um erro ao tentar adicionar o produto!");
            return null;
        }

    }
}
