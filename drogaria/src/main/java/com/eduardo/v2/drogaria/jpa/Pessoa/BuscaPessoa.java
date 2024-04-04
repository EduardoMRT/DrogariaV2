package com.eduardo.v2.drogaria.jpa.Pessoa;

import com.eduardo.v2.drogaria.domain.Pessoa;
import com.eduardo.v2.drogaria.repository.PessoaRepository;
import org.hibernate.collection.spi.PersistentSortedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class BuscaPessoa {
    private final ApplicationContext applicationContext;

    @Autowired
    private PessoaRepository pessoaRepository;

    public BuscaPessoa(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    public Pessoa buscarPessoaPorCpf(String cpf){
        try {
            Pessoa pessoa= pessoaRepository.findByCpf(cpf);
            System.out.println("Nome da Pessoa"+pessoa.getNome());
            return pessoa;
        }catch (RuntimeException e){
            System.out.println("Não foi possível buscar a pessoa!");
            e.printStackTrace();
            return null;
        }
    }
}
