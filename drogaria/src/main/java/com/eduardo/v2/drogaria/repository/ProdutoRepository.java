package com.eduardo.v2.drogaria.repository;

import com.eduardo.v2.drogaria.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
