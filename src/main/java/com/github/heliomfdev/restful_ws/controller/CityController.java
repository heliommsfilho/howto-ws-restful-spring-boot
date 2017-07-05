package com.github.heliomfdev.restful_ws.controller;

import com.github.heliomfdev.restful_ws.dto.CityDTO;
import com.github.heliomfdev.restful_ws.service.CityService;
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
 * CityController provides a interface to retrieve Cities stored in database.
 *
 * Available services:
 * <ul>
 *     <li>Get all Cities</li>
 *     <li>Get a City by name</li>
 *     <li>Get all Cities from a State</li>
 * </ul>
 * */
@RestController
@RequestMapping(value = "/city")
public class CityController {

    @Autowired
    private CityService service;

    /**
     * Returns all Cities stored in database.
     * */
    @RequestMapping(value = "/all", produces = "application/json", method = RequestMethod.GET)
    public ResponseEntity<List<CityDTO>> getAll() {
         return CreateResponseEntity.createFromListDTO(service.getAll());
    }

    /**
     * Returns Cities containing the provided name.
     *
     * @param name of the city
     * */
    @RequestMapping(value = "name/{name}", produces = "application/json", method = RequestMethod.GET)
    public ResponseEntity<List<CityDTO>> getByName(@PathVariable String name) {
        return CreateResponseEntity.createFromListDTO(service.getByName(name));
    }

    /**
     * Returns Cities from a specific State.
     *
     * @param abbreviation of the State
     * */
    @RequestMapping(value = "/state/{abbreviation}", produces = "application/json", method = RequestMethod.GET)
    public ResponseEntity<List<CityDTO>> getByState(@PathVariable String abbreviation) {
        return CreateResponseEntity.createFromListDTO(service.getByStateAbbreviation(abbreviation));
    }
}
