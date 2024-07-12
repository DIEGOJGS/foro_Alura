package com.api.foro_Alura.controller;

import com.api.foro_Alura.model.Topico;
import com.api.foro_Alura.repository.TopicoRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class TopicoControllerTests {

    @Mock
    private TopicoRepository topicoRepository;

    @InjectMocks
    private TopicoController topicoController;

    @Test
    void testObtenerTopico() {
        MockitoAnnotations.openMocks(this);
        Topico topico = new Topico();
        topico.setId(1L);
        topico.setTitulo("Título de prueba");

        when(topicoRepository.findById(1L)).thenReturn(Optional.of(topico));

        ResponseEntity<Topico> response = topicoController.obtenerTopico(1L);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(topico, response.getBody());
    }
}
