package com.eduardo.v2.drogaria.jpa.Usuario;

import java.util.List;

import org.springframework.stereotype.Component;

import com.eduardo.v2.drogaria.domain.Usuario;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Component
public class CadastraUsuario {
    @PersistenceContext
    private EntityManager manager;
    public List<Usuario> listar(){
        TypedQuery<Usuario> query = manager.createQuery("from usuario", Usuario.class);
        return query.getResultList();
    }

    public Usuario buscar(Long codigo){
        return manager.find(Usuario.class, codigo);
    }


    @Transactional
    public Usuario adicionar(Usuario usuario){
        return manager.merge(usuario);
    }

    @Transactional
    public void remover(Usuario usuario){
        usuario = buscar(usuario.getCodUsuario());
        manager.remove(usuario);
    }
}
