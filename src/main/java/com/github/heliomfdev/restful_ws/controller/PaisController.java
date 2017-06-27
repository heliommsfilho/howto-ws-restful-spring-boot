package com.github.heliomfdev.restful_ws.controller;

import com.github.heliomfdev.restful_ws.dto.PaisDTO;
import com.github.heliomfdev.restful_ws.model.Estado;
import com.github.heliomfdev.restful_ws.model.Pais;
import com.github.heliomfdev.restful_ws.repository.PaisRepository;
import com.github.heliomfdev.restful_ws.service.PaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pais")
public class PaisController {

    @Autowired
    private PaisService service;

    @RequestMapping(value = "/sigla/{sigla}", method = RequestMethod.GET)
    public PaisDTO obterPorSigla(@PathVariable String sigla) {
        return service.obterPorSigla(sigla);
    }

    @RequestMapping(value = "/nome/{nome}", method = RequestMethod.GET)
    public List<PaisDTO> obterPorNome(@PathVariable String nome) {
        return service.obterPorNome(nome);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<PaisDTO> obterTodos() {
        return service.obterTodos();
    }
}
