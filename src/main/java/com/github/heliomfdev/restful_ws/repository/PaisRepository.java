package com.github.heliomfdev.restful_ws.repository;

import com.github.heliomfdev.restful_ws.model.Pais;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaisRepository extends JpaRepository<Pais, Long> {

    Pais findBySigla(String sigla);

    List<Pais> findByNomeContaining(String nome);
}
