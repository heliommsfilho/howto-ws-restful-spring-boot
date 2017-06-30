package com.github.heliomfdev.restful_ws.service;

import com.github.heliomfdev.restful_ws.dto.PaisDTO;
import com.github.heliomfdev.restful_ws.dto.mapper.Mapper;
import com.github.heliomfdev.restful_ws.model.Pais;
import com.github.heliomfdev.restful_ws.repository.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PaisService extends GenericService<Pais, PaisDTO>{

    @Autowired
    private PaisRepository repository;



    public PaisDTO obterPorSigla(String sigla) {
        return Mapper.map(repository.findBySigla(sigla.trim()), PaisDTO.class);
    }

    public List<PaisDTO> obterPorNome(String nome) {
        return super.listMapper.map(repository.findByNomeContaining(nome.trim()), PaisDTO.class);
    }

    public List<PaisDTO> obterTodos() {
        return super.listMapper.map(repository.findAll(), PaisDTO.class);
    }
}
