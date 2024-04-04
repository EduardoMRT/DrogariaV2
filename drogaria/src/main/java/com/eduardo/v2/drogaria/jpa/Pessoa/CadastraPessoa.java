package com.eduardo.v2.drogaria.jpa.Pessoa;

import com.eduardo.v2.drogaria.domain.Pessoa;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CadastraPessoa {
    @PersistenceContext
    private EntityManager manager;
    public List<Pessoa> listar(){
        TypedQuery<Pessoa> query = manager.createQuery("from pessoa", Pessoa.class);
        return query.getResultList();
    }

    public Pessoa buscar(Long cod){
        return manager.find(Pessoa.class, cod);
    }
}
