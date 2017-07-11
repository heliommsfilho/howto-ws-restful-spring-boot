package com.github.heliomfdev.restful_ws.controller;

import com.github.heliomfdev.restful_ws.dto.CountryDTO;
import com.github.heliomfdev.restful_ws.service.CountryService;
import com.github.heliomfdev.restful_ws.util.CreateResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Hélio Márcio Filho
 * @see <a href="https://github.com/heliomf-dev">Visit my GitHub</a>
 * @since 1.0
 * @version 1.0
 *
 * CountryController provides a interface to retrieve Countries stored in database.
 *
 * Available services:
 * <ul>
 *     <li>Get all States</li>
 *     <li>Get States containing the provided name</li>
 *     <li>Get State having the provided abbreviation</li>
 *     <li>Get States from a specific Country</li>
 * </ul>
 * */
@RestController
@RequestMapping("/country")
public class CountryController {

    @Autowired
    private CountryService service;

    /**
     * Returns all Countries stored in database.
     * */
    @RequestMapping(value = "/all", produces = "application/json", method = RequestMethod.GET)
    public ResponseEntity<List<CountryDTO>> getAll() {
        return CreateResponseEntity.createFromListDTO(service.getAll());
    }

    /**
     * Returns Countries from a specific Country.
     *
     * @param abbreviation abbreviation of the Country
     * */
    @RequestMapping(value = "/abbreviation/{abbreviation}", produces = "application/json", method = RequestMethod.GET)
    public ResponseEntity<CountryDTO> getByAbbreviation(@PathVariable String abbreviation) {
        return CreateResponseEntity.createFromDTO(service.getByAbbreviation(abbreviation));
    }

    /**
     * Returns Countries containing the provided name.
     *
     * @param name of the country
     * */
    @RequestMapping(value = "/name/{name}", produces = "application/json", method = RequestMethod.GET)
    public ResponseEntity<List<CountryDTO>> getByName(@PathVariable String name) {
        return CreateResponseEntity.createFromListDTO(service.getByName(name));
    }
}
