package com.github.heliomfdev.restful_ws.controller;

import com.github.heliomfdev.restful_ws.model.Estado;
import com.github.heliomfdev.restful_ws.model.Pais;
import com.github.heliomfdev.restful_ws.repository.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pais")
public class PaisController {

    @Autowired
    PaisRepository paisRepository;

    @RequestMapping(value = "/sigla/{sigla}", method = RequestMethod.GET)
    public Pais getBySigla(@PathVariable String sigla) {
        return paisRepository.findBySigla(sigla);
    }

    @RequestMapping(value = "/nome/{nome}")
    public List<Pais> getByNome(@PathVariable String nome) {
        return paisRepository.findByNomeContaining(nome);
    }
}
