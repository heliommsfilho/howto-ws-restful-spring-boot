package com.github.heliomfdev.restful_ws.service;

import com.github.heliomfdev.restful_ws.dto.CityDTO;
import com.github.heliomfdev.restful_ws.model.City;
import com.github.heliomfdev.restful_ws.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Hélio Márcio Filho
 * @see <a href="https://github.com/heliomf-dev">Visit my GitHub</a>
 * @since 1.0
 * @version 1.0
 *
 * City service to manage all the business logic of dealing with City entities.
 * */
@Service
@Transactional
public class CityService extends GenericService<City, CityDTO> {

    @Autowired
    private CityRepository repository;

    public List<CityDTO> getByStateAbbreviation(String stateAbbreviation) {
        return super.listMapper.map(repository.findByState_Abbreviation(stateAbbreviation.trim()), CityDTO.class);
    }

    public List<CityDTO> getByName(String name) {
        return super.listMapper.map(repository.findByNameContaining(name.trim()), CityDTO.class);
    }

    public List<CityDTO> getAll() {
        return super.listMapper.map(repository.findAll(), CityDTO.class);
    }
}
