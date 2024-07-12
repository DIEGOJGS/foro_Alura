package com.api.foro_Alura.controller;

import com.api.foro_Alura.model.Topico;
import com.api.foro_Alura.repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;

import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository repository;

    @PostMapping
    public ResponseEntity<Topico> crearTopico(@RequestBody @Valid Topico topico) {
        topico.setFechaCreacion(LocalDateTime.now());
        Topico savedTopico = repository.save(topico);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedTopico);
    }

    @GetMapping
    public List<Topico> listarTopicos() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Topico> obtenerTopico(@PathVariable Long id) {
        Optional<Topico> topico = repository.findById(id);
        if (topico.isPresent()) {
            return ResponseEntity.ok(topico.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Topico> actualizarTopico(@PathVariable Long id, @RequestBody @Valid Topico nuevoTopico) {
        return repository.findById(id)
                .map(topico -> {
                    topico.setTitulo(nuevoTopico.getTitulo());
                    topico.setMensaje(nuevoTopico.getMensaje());
                    topico.setStatus(nuevoTopico.getStatus());
                    topico.setAutor(nuevoTopico.getAutor());
                    topico.setCurso(nuevoTopico.getCurso());
                    Topico updatedTopico = repository.save(topico);
                    return ResponseEntity.ok(updatedTopico);
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> eliminarTopico(@PathVariable Long id) {
        return repository.findById(id)
                .map(topico -> {
                    repository.deleteById(id);
                    return ResponseEntity.noContent().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}
