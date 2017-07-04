package com.github.heliomfdev.restful_ws.controller;

import com.github.heliomfdev.restful_ws.dto.CountryDTO;
import com.github.heliomfdev.restful_ws.service.CountryService;
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

    @RequestMapping(value = "/all", consumes = "application/json", produces = "application/json", method = RequestMethod.POST)
    public ResponseEntity<List<CountryDTO>> getAll() {
        return CreateResponseEntity.createFromListDTO(service.getAll());
    }

    @RequestMapping(value = "/abbreviation/{abbreviation}", consumes = "application/json", produces = "application/json", method = RequestMethod.POST)
    public ResponseEntity<CountryDTO> getByAbbreviation(@PathVariable String abbreviation) {
        return CreateResponseEntity.createFromDTO(service.getByAbbreviation(abbreviation));
    }

    @RequestMapping(value = "/name/{name}", consumes = "application/json", produces = "application/json", method = RequestMethod.POST)
    public ResponseEntity<List<CountryDTO>> obterPorNome(@PathVariable String name) {
        return CreateResponseEntity.createFromListDTO(service.getByName(name));
    }
}
