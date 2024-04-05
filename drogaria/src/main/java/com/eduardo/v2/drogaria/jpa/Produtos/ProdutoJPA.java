package com.eduardo.v2.drogaria.jpa.Produtos;

import com.eduardo.v2.drogaria.domain.Produto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProdutoJPA {
    @PersistenceContext
    private EntityManager manager;

    public List<Produto> listar() {
        TypedQuery<Produto> query = manager.createQuery("from produto", Produto.class);
        return query.getResultList();
    }

    public Produto buscar(Long cod){
        return manager.find(Produto.class, cod);
    }

    @Transactional
    public Produto adicionar(Produto produto){
        return manager.merge(produto);
    }

    @Transactional
    public void deletar(Produto produto){
        produto = buscar(produto.getCod_produto());
        manager.remove(produto);
    }
}
