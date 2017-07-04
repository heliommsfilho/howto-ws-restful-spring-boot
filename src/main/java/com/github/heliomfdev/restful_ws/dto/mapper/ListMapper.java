package com.github.heliomfdev.restful_ws.dto.mapper;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Hélio Márcio Filho
 * @see <a href="https://github.com/heliomf-dev">Visit my GitHub</a>
 * @since 1.0
 * @version 1.0
 *
 * Receives a list of {@link Object} and returns a resulting list of mapped {@link Object}.
 * */
public class ListMapper<S, D> {

    /**
     * This method map a list of objects to a list of Data Transfer Objects. This method uses {@link Mapper#map(Object, Class)}
     * @see Mapper
     *
     * @param sourceList is the input list containing model objects to be mapped.
     * @param destinationType is the class type of destination object. If mapping a list of Countries,
     *                        this parameter would be like CountryDTO.class.
     * */
    public List<D> map(List<S> sourceList, Class<D> destinationType) {
        List<D> destinationList = new ArrayList<>();

        if (sourceList != null) {
            for (S listItem : sourceList) {
                D resultItem = Mapper.map(listItem, destinationType);
                destinationList.add(resultItem);
            }
        }

        return destinationList;
    }
}
