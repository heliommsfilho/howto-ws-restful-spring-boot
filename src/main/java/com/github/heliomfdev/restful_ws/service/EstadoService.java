package com.github.heliomfdev.restful_ws.service;

import com.github.heliomfdev.restful_ws.dto.EstadoDTO;
import com.github.heliomfdev.restful_ws.dto.mapper.Mapper;
import com.github.heliomfdev.restful_ws.model.Estado;
import com.github.heliomfdev.restful_ws.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstadoService extends GenericService<Estado, EstadoDTO> {

    @Autowired
    private EstadoRepository repository;

    public EstadoDTO obterPorSigla(String siglaEstado) {
        return Mapper.map(repository.findBySigla(siglaEstado.trim()), EstadoDTO.class);
    }

    public List<EstadoDTO> obterPorSiglaPais(String siglaPais) {
        return super.listMapper.map(repository.findByPais_Sigla(siglaPais.trim()), EstadoDTO.class);
    }

    public List<EstadoDTO> obterPorNome(String nome) {
        return super.listMapper.map(repository.findByNomeContaining(nome.trim()), EstadoDTO.class);
    }

    public List<EstadoDTO> obterTodos() {
        return super.listMapper.map(repository.findAll(), EstadoDTO.class);
    }
}
