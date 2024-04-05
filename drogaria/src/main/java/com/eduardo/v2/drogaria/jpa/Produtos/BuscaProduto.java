package com.eduardo.v2.drogaria.jpa.Produtos;

import com.eduardo.v2.drogaria.domain.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class BuscaProduto {
    @Autowired
    private final ProdutoJPA produtoJPA;
    private final ApplicationContext applicationContext;

    public BuscaProduto(ProdutoJPA produtoJPA, ApplicationContext applicationContext) {
        this.produtoJPA = produtoJPA;
        this.applicationContext = applicationContext;
    }

    public Produto buscarProdutoPorCodigo(Long cod){
        try{
            Produto produto = produtoJPA.buscar(cod);
            return produto;
        }catch (RuntimeException e){
            System.out.println("Ocorreu um erro ao tentar buscar o produto!");
            e.printStackTrace();
            return null;
        }
    }



}
