package com.github.heliomfdev.restful_ws.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.Serializable;

/**
 * @author Hélio Márcio Filho
 * @see <a href="https://github.com/heliomf-dev">Visit my GitHub</a>
 * @since 1.0
 * @version 1.0
 *
 * A Data Transfer Object representation of a Country entity.
 * */
@JsonSerialize
public class CountryDTO implements Serializable {

    private static final long serialVersionUID = -6836083760892112332L;

    private String name;
    private String abbreviation;
    private int numberOfStates;

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

    public Integer getNumberOfStates() {
        return numberOfStates;
    }

    public void setNumberOfStates(Integer numberOfStates) {
        this.numberOfStates = numberOfStates;
    }
}
