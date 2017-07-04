package com.github.heliomfdev.restful_ws.service;

import com.github.heliomfdev.restful_ws.dto.CountryDTO;
import com.github.heliomfdev.restful_ws.dto.mapper.Mapper;
import com.github.heliomfdev.restful_ws.model.Country;
import com.github.heliomfdev.restful_ws.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Hélio Márcio Filho
 * @see <a href="https://github.com/heliomf-dev">Visit my GitHub</a>
 * @since 1.0
 * @version 1.0
 *
 * Country service to manage all the business logic of dealing with Country entities.
 * */
@Service
public class CountryService extends GenericService<Country, CountryDTO>{

    @Autowired
    private CountryRepository repository;

    public CountryDTO getByAbbreviation(String abbreviation) {
        return Mapper.map(repository.findByAbbreviation(abbreviation.trim()), CountryDTO.class);
    }

    public List<CountryDTO> getByName(String name) {
        return super.listMapper.map(repository.findByNameContaining(name.trim()), CountryDTO.class);
    }

    public List<CountryDTO> getAll() {
        return super.listMapper.map(repository.findAll(), CountryDTO.class);
    }
}
