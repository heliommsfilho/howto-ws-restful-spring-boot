package com.github.heliomfdev.restful_ws.controller;

import com.github.heliomfdev.restful_ws.dto.PaisDTO;
import com.github.heliomfdev.restful_ws.model.Estado;
import com.github.heliomfdev.restful_ws.model.Pais;
import com.github.heliomfdev.restful_ws.repository.PaisRepository;
import com.github.heliomfdev.restful_ws.service.PaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pais")
public class PaisController {

    @Autowired
    private PaisService service;

    @RequestMapping
    @ResponseBody
    public List<PaisDTO> obterTodos() {
        return service.obterTodos();
    }

    @RequestMapping(value = "/sigla/{sigla}")
    @ResponseBody
    public PaisDTO obterPorSigla(@PathVariable String sigla) {
        return service.obterPorSigla(sigla);
    }

    @RequestMapping(value = "/nome/{nome}")
    @ResponseBody
    public List<PaisDTO> obterPorNome(@PathVariable String nome) {
        return service.obterPorNome(nome);
    }
}
