package com.api.foro_Alura.repository;

import com.api.foro_Alura.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
