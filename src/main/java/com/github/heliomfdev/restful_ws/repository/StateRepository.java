package com.github.heliomfdev.restful_ws.repository;

import com.github.heliomfdev.restful_ws.model.State;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Hélio Márcio Filho
 * @see <a href="https://github.com/heliomf-dev">Visit my GitHub</a>
 * @since 1.0
 * @version 1.0
 *
 * State repository that retrieve states from database.
 * */
public interface StateRepository extends JpaRepository<State, Long> {

    State findByAbbreviation(String abbreviation);

    List<State> findByNameContaining(String name);

    List<State> findByCountry_Abbreviation(String countryAbbreviation);
}
