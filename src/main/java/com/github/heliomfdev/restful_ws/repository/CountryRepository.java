package com.github.heliomfdev.restful_ws.repository;

import com.github.heliomfdev.restful_ws.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Hélio Márcio Filho
 * @see <a href="https://github.com/heliomf-dev">Visit my GitHub</a>
 * @since 1.0
 * @version 1.0
 *
 * Country repository that retrieve countries from database.
 * */
public interface CountryRepository extends JpaRepository<Country, Long> {

    Country findByAbbreviation(String abbreviation);

    List<Country> findByNameContaining(String name);
}
