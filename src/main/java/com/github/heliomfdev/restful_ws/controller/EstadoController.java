package com.github.heliomfdev.restful_ws.controller;

import com.github.heliomfdev.restful_ws.dto.EstadoDTO;
import com.github.heliomfdev.restful_ws.service.EstadoService;
import com.github.heliomfdev.restful_ws.util.CreateResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/estado")
public class EstadoController {

    @Autowired
    private EstadoService service;

    @RequestMapping
    public ResponseEntity<List<EstadoDTO>> obterTodosEstados() {
        return CreateResponseEntity.createFromListDTO(service.obterTodos());
    }

    @RequestMapping(value = "/sigla/{sigla}")
    public ResponseEntity<EstadoDTO> obterPorSigla(@PathVariable String sigla) {
        return CreateResponseEntity.createFromDTO(service.obterPorSigla(sigla));
    }

    @RequestMapping(value = "/siglaPais/{sigla}")
    public ResponseEntity<List<EstadoDTO>> obterPorSiglaPais(@PathVariable String sigla) {
        return CreateResponseEntity.createFromListDTO(service.obterPorSiglaPais(sigla));
    }

    @RequestMapping(value = "/nome/{nome}")
    public ResponseEntity<List<EstadoDTO>> obterPorNome(@PathVariable String nome) {
        return CreateResponseEntity.createFromListDTO(service.obterPorNome(nome));
    }
}