package com.api.foro_Alura.controller;

import com.api.foro_Alura.model.Respuesta;
import com.api.foro_Alura.repository.RespuestaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/respuestas")
public class RespuestaController {

    @Autowired
    private RespuestaRepository repository;

    @PostMapping
    public ResponseEntity<Respuesta> crearRespuesta(@RequestBody @Valid Respuesta respuesta) {
        Respuesta savedRespuesta = repository.save(respuesta);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedRespuesta);
    }

    @GetMapping
    public List<Respuesta> listarRespuestas() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Respuesta> obtenerRespuesta(@PathVariable Long id) {
        Optional<Respuesta> respuesta = repository.findById(id);
        if (respuesta.isPresent()) {
            return ResponseEntity.ok(respuesta.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Respuesta> actualizarRespuesta(@PathVariable Long id, @RequestBody @Valid Respuesta nuevaRespuesta) {
        return repository.findById(id)
                .map(respuesta -> {
                    respuesta.setMensaje(nuevaRespuesta.getMensaje());
                    respuesta.setAutor(nuevaRespuesta.getAutor());
                    Respuesta updatedRespuesta = repository.save(respuesta);
                    return ResponseEntity.ok(updatedRespuesta);
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> eliminarRespuesta(@PathVariable Long id) {
        return repository.findById(id)
                .map(respuesta -> {
                    repository.deleteById(id);
                    return ResponseEntity.noContent().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}
