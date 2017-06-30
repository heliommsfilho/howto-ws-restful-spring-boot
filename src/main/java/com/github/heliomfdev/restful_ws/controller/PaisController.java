package com.github.heliomfdev.restful_ws.controller;

import com.github.heliomfdev.restful_ws.dto.PaisDTO;
import com.github.heliomfdev.restful_ws.service.PaisService;
import com.github.heliomfdev.restful_ws.util.CreateResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pais")
public class PaisController {

    @Autowired
    private PaisService service;

    @RequestMapping
    public ResponseEntity<List<PaisDTO>> obterTodos() {
        return CreateResponseEntity.createFromListDTO(service.obterTodos());
    }

    @RequestMapping(value = "/sigla/{sigla}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<PaisDTO> obterPorSigla(@PathVariable String sigla) {
        return CreateResponseEntity.createFromDTO(service.obterPorSigla(sigla));
    }

    @RequestMapping(value = "/nome/{nome}", method = RequestMethod.GET, produces="application/json")
    public ResponseEntity<List<PaisDTO>> obterPorNome(@PathVariable String nome) {
        return CreateResponseEntity.createFromListDTO(service.obterPorNome(nome));
    }
}
