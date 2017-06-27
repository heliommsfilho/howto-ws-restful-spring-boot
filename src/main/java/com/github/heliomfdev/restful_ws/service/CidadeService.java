package com.github.heliomfdev.restful_ws.service;

import com.github.heliomfdev.restful_ws.dto.CidadeDTO;
import com.github.heliomfdev.restful_ws.model.Cidade;
import com.github.heliomfdev.restful_ws.repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CidadeService extends GenericService<Cidade, CidadeDTO> {

    @Autowired
    private  CidadeRepository repository;

    public List<CidadeDTO> obterPorSiglaEstado(String siglaEstado) {
        return super.listMapper.map(repository.findByEstado_Sigla(siglaEstado.trim()), CidadeDTO.class);
    }

    public List<CidadeDTO> obterPorNome(String nome) {
        return super.listMapper.map(repository.findByNomeContaining(nome.trim()), CidadeDTO.class);
    }
}
