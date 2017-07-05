package com.github.heliomfdev.restful_ws.controller;

import com.github.heliomfdev.restful_ws.dto.StateDTO;
import com.github.heliomfdev.restful_ws.service.StateService;
import com.github.heliomfdev.restful_ws.util.CreateResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Hélio Márcio Filho
 * @see <a href="https://github.com/heliomf-dev">Visit my GitHub</a>
 * @since 1.0
 * @version 1.0
 *
 * StateController provides a interface to retrieve States stored in database.
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
@RequestMapping("/state")
public class StateController {

    @Autowired
    private StateService service;

    /**
     * Returns all States stored in database.
     * */
    @RequestMapping(value = "/all", produces = "application/json", method = RequestMethod.GET)
    public ResponseEntity<List<StateDTO>> getAll() {
        return CreateResponseEntity.createFromListDTO(service.getAll());
    }

    /**
     * Returns States containing the provided name.
     *
     * @param name of the city
     * */
    @RequestMapping(value = "/name/{name}", produces = "application/json", method = RequestMethod.GET)
    public ResponseEntity<List<StateDTO>> getByName(@PathVariable String name) {
        return CreateResponseEntity.createFromListDTO(service.getByName(name));
    }

    /**
     * Returns State having the provided abbreviation.
     *
     * @param abbreviation of the State
     * */
    @RequestMapping(value = "/abbreviation/{abbreviation}", produces = "application/json", method = RequestMethod.GET)
    public ResponseEntity<StateDTO> getByStateAbbreviation(@PathVariable String abbreviation) {
        return CreateResponseEntity.createFromDTO(service.getByAbbreviation(abbreviation));
    }

    /**
     * Returns States from a specific Country.
     *
     * @param countryAbbreviation abbreviation of the Country
     * */
    @RequestMapping(value = "/country/{countryAbbreviation}", produces = "application/json", method = RequestMethod.GET)
    public ResponseEntity<List<StateDTO>> getByCountryAbbreviation(@PathVariable String countryAbbreviation) {
        return CreateResponseEntity.createFromListDTO(service.getByCountryAbbreviation(countryAbbreviation));
    }
}