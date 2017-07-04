package com.github.heliomfdev.restful_ws.dto.mapper;

import com.github.heliomfdev.restful_ws.dto.CityDTO;
import com.github.heliomfdev.restful_ws.model.City;
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

    private Mapper() {
        /* Should not be instantiated */
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

        ModelMapper modelMapper = new ModelMapper();

        /* Configuring explicit mapping for City */
        modelMapper.addMappings(new PropertyMap<City, CityDTO>() {
            @Override
            protected void configure() {
                String countryName = source.getState().getCountry().getName();
                map().setCountryName(countryName);
            }});

        return source != null ? modelMapper.map(source, destinationType) : null;
    }
}