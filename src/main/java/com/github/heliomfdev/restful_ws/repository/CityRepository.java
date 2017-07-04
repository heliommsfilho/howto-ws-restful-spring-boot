package com.github.heliomfdev.restful_ws.repository;


import com.github.heliomfdev.restful_ws.model.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Hélio Márcio Filho
 * @see <a href="https://github.com/heliomf-dev">Visit my GitHub</a>
 * @since 1.0
 * @version 1.0
 *
 * City repository that retrieve cities from database.
 * */
public interface CityRepository extends JpaRepository<City, Long> {

    List<City> findByNameContaining(String name);

    List<City> findByState_Abbreviation(String stateAbbreviation);

    List<City> findAll();
}
