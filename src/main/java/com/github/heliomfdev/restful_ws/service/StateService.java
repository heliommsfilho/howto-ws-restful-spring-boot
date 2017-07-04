package com.github.heliomfdev.restful_ws.service;

import com.github.heliomfdev.restful_ws.dto.StateDTO;
import com.github.heliomfdev.restful_ws.dto.mapper.Mapper;
import com.github.heliomfdev.restful_ws.model.State;
import com.github.heliomfdev.restful_ws.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Hélio Márcio Filho
 * @see <a href="https://github.com/heliomf-dev">Visit my GitHub</a>
 * @since 1.0
 * @version 1.0
 *
 * State service to manage all the business logic of dealing with State entities.
 * */
@Service
public class StateService extends GenericService<State, StateDTO> {

    @Autowired
    private StateRepository repository;

    public StateDTO getByAbbreviation(String abbreviation) {
        return Mapper.map(repository.findByAbbreviation(abbreviation.trim()), StateDTO.class);
    }

    public List<StateDTO> getByCountryAbbreviation(String countryAbbreviation) {
        return super.listMapper.map(repository.findByCountry_Abbreviation(countryAbbreviation.trim()), StateDTO.class);
    }

    public List<StateDTO> getByName(String name) {
        return super.listMapper.map(repository.findByNameContaining(name.trim()), StateDTO.class);
    }

    public List<StateDTO> getAll() {
        return super.listMapper.map(repository.findAll(), StateDTO.class);
    }
}
