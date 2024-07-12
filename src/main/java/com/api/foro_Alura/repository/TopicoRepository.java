package com.api.foro_Alura.repository;


import com.api.foro_Alura.model.Topico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicoRepository extends JpaRepository<Topico, Long> {
}
