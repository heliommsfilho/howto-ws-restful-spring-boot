package com.github.heliomfdev.restful_ws.repository;


import com.github.heliomfdev.restful_ws.model.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {

    List<Cidade> findByNomeContaining(String nome);

    List<Cidade> findByEstado_Sigla(String siglaEstado);

    List<Cidade> findAll();
}
