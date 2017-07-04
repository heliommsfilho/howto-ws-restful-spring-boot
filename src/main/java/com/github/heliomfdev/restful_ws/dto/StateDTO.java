package com.github.heliomfdev.restful_ws.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.Serializable;

/**
 * @author Hélio Márcio Filho
 * @see <a href="https://github.com/heliomf-dev">Visit my GitHub</a>
 * @since 1.0
 * @version 1.0
 *
 * A Data Transfer Object representation of a State entity.
 * */
@JsonSerialize
public class StateDTO implements Serializable {

    private static final long serialVersionUID = 8645121583750134482L;

    private String countryName;
    private String name;
    private String abbreviation;
    private Integer numberOfCities;

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public Integer getNumberOfCities() {
        return numberOfCities;
    }

    public void setNumberOfCities(Integer numberOfCities) {
        this.numberOfCities = numberOfCities;
    }
}
