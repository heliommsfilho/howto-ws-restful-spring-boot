package com.github.heliomfdev.restful_ws.controller;

import com.github.heliomfdev.restful_ws.dto.CidadeDTO;
import com.github.heliomfdev.restful_ws.service.CidadeService;
import com.github.heliomfdev.restful_ws.util.CreateResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/cidade")
public class CidadeController {

    @Autowired
    private CidadeService service;

    @ResponseBody
    @RequestMapping
    public ResponseEntity<List<CidadeDTO>> obterTodasCidades() {
        return CreateResponseEntity.createFromListDTO(service.obterTodasCidades());
    }

    @ResponseBody
    @RequestMapping(value = "/nome/{nome}")
    public ResponseEntity<List<CidadeDTO>> obterPorNome(@PathVariable String nome) {
        return CreateResponseEntity.createFromListDTO(service.obterPorNome(nome));
    }

    @ResponseBody
    @RequestMapping(value = "/estado/{siglaEstado}")
    public ResponseEntity<List<CidadeDTO>> obterPorEstado(@PathVariable String siglaEstado) {
        return CreateResponseEntity.createFromListDTO(service.obterPorSiglaEstado(siglaEstado));
    }
}
