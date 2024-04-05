package com.eduardo.v2.drogaria.jpa.Produtos;

import com.eduardo.v2.drogaria.domain.Produto;
import com.eduardo.v2.drogaria.domain.Usuario;
import com.eduardo.v2.drogaria.jpa.Usuario.CadastraUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ListarProduto {
    private final ApplicationContext applicationContext;

    @Autowired
    public ListarProduto(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }


    public List<Produto> listar(){
        ProdutoJPA produtoJPA = applicationContext.getBean(ProdutoJPA.class);
        List<Produto> produtos = produtoJPA.listar();
        return produtos;
    }
}
