package com.eduardo.v2.drogaria.jpa.Estado;

import com.eduardo.v2.drogaria.domain.Estado;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CadastraEstado {
    @PersistenceContext
    private EntityManager manager;
    public List<Estado> listar(){
        TypedQuery<Estado> query = manager.createQuery("from estado", Estado.class);
        return query.getResultList();
    }

    public Estado buscar(Long codigo){
        return manager.find(Estado.class, codigo);
    }


    @Transactional
    public Estado adicionar(Estado estado){
        return manager.merge(estado);
    }

    @Transactional
    public void remover(Estado estado){
        estado = buscar(estado.getCodigo());
        manager.remove(estado);
    }
}
