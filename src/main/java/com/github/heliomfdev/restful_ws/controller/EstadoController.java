package com.github.heliomfdev.restful_ws.controller;

import com.github.heliomfdev.restful_ws.dto.EstadoDTO;
import com.github.heliomfdev.restful_ws.model.Estado;
import com.github.heliomfdev.restful_ws.service.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estado")
public class EstadoController {

    @Autowired
    EstadoService service;

    @RequestMapping
    @ResponseBody
    public List<EstadoDTO> obterTodosEstados() {
        return service.obterTodos();
    }

    @RequestMapping(value = "/sigla/{sigla}")
    @ResponseBody
    public EstadoDTO obterPorSigla(@PathVariable String sigla) {
        return service.obterPorSigla(sigla);
    }

    @RequestMapping(value = "/siglaPais/{sigla}")
    @ResponseBody
    public List<EstadoDTO> obterPorSiglaPais(@PathVariable String sigla) {
        return service.obterPorSiglaPais(sigla);
    }

    @RequestMapping(value = "/nome/{nome}")
    @ResponseBody
    public List<EstadoDTO> obterPorNome(@PathVariable String nome) {
        return service.obterPorNome(nome);
    }
}
