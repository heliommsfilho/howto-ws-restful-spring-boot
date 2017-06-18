package com.github.heliomfdev.restful_ws.repository;

import com.github.heliomfdev.restful_ws.model.Estado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EstadoRepository extends JpaRepository<Estado, Long> {

    Estado findBySigla(String sigla);

    List<Estado> findByNomeContaining(String sigla);

    List<Estado> findByPais_Sigla(String siglaPais);
}
