package com.eduardo.v2.drogaria.repository;

import com.eduardo.v2.drogaria.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
