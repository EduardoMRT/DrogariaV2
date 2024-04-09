package com.eduardo.v2.drogaria.jpa.Produtos;

import com.eduardo.v2.drogaria.domain.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Component
public class ExcluiProduto {
    private final ApplicationContext applicationContext;

    @Autowired
    public ExcluiProduto(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    public Produto remover(Produto produto){
        try{
            ProdutoJPA produtoJPA = applicationContext.getBean(ProdutoJPA.class);
            produtoJPA.deletar(produto);
            return produto;
        }catch (RuntimeException e){
            e.printStackTrace();
            System.out.println("Ocorreu um erro ao tentar excluir o produto");
            return null;
        }
    }

}
