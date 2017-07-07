package com.github.heliomfdev.restful_ws.dto.mapper;

import com.github.heliomfdev.restful_ws.dto.CityDTO;
import com.github.heliomfdev.restful_ws.dto.CountryDTO;
import com.github.heliomfdev.restful_ws.dto.StateDTO;
import com.github.heliomfdev.restful_ws.model.City;
import com.github.heliomfdev.restful_ws.model.Country;
import com.github.heliomfdev.restful_ws.model.State;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

import java.lang.reflect.Type;

/**
 * @author Hélio Márcio Filho
 * @see <a href="https://github.com/heliomf-dev">Visit my GitHub</a>
 * @since 1.0
 * @version 1.0
 *
 * Receives a {@link Object} and returns a resulting mapped {@link Object}.
 * */
public class Mapper {

    private static ModelMapper modelMapper = getInstance();

    private Mapper() {
        /* Should not be instantiated */
    }

    /**
     * Singleton to ensure a single instance of modelMapper.
     * */
    private static ModelMapper getInstance() {

        if (modelMapper == null) {
            modelMapper = new ModelMapper();
            createAndSetPropertyMaps();
            return modelMapper;
        } else {
            return modelMapper;
        }
    }

    /**
     * This method map a {@link Object} and returns a resulting mapped {@link Object}.
     * This method uses {@link ModelMapper#map(Object, Type)}
     * @see ModelMapper
     *
     * @param source is the input {@link Object} to be mapped.
     * @param destinationType is the class type of destination object. If mapping a Country,
     *                        this parameter would be like CountryDTO.class.
     * */
    @SuppressWarnings("unchecked")
    public static <S, D> D map(S source, Class<D> destinationType) {

        return source != null ? modelMapper.map(source, destinationType) : null;
    }

    /**
     * This static method sets all custom explicit mappings into {@link ModelMapper} attribute.
     * <i>Created due a issue caused by excessive addMappings() calls, which were resulting in NullPointerException.</i>
     * */
    private static void createAndSetPropertyMaps() {

        PropertyMap<Country, CountryDTO> propertyMapCountry = new PropertyMap<Country, CountryDTO>() {
            @Override
            protected void configure() {
                Integer numberOfStates = source.getStates().size();
                map().setNumberOfStates(numberOfStates);
            }
        };

        PropertyMap<State, StateDTO> propertyMapState = new PropertyMap<State, StateDTO>() {
            @Override
            protected void configure() {
                Integer numberOfCities = source.getCities().size();
                map().setNumberOfCities(numberOfCities);
            }
        };

        PropertyMap<City, CityDTO> propertyMapCity = new PropertyMap<City, CityDTO>() {
            @Override
            protected void configure() {
                String countryName = source.getState().getCountry().getName();
                map().setCountryName(countryName);
            }
        };

        modelMapper.addMappings(propertyMapCountry);
        modelMapper.addMappings(propertyMapState);
        modelMapper.addMappings(propertyMapCity);
    }
}