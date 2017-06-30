package com.github.heliomfdev.restful_ws.dto.mapper;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Hélio Márcio Filho
 * @version 1.0
 * @since 1.0
 *
 * Receives a list of objects and map to a DTO object.
 * */
public class ListMapper<S, D> {

    public List<D> map(List<S> sourceList, Class<D> destinationType) {
        List<D> destinationList = new ArrayList<>();

        for (S listItem : sourceList) {
            D resultItem =  Mapper.map(listItem, destinationType);
            destinationList.add(resultItem);
        }

        return destinationList;
    }
}
