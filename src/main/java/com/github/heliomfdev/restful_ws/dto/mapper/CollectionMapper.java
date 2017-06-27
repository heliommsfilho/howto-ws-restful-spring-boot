package com.github.heliomfdev.restful_ws.dto.mapper;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Hélio Márcio Filho
 * @version 1.0
 * @since 1.0
 *
 * Receives a list of objects and map to a DTO object.
 * */
public class CollectionMapper<S, D> {

    public List<D> map(List<S> sourceList, Class<D> destinationType) {
        ModelMapper mapper = Mapper.getInstance();
        List<D> destinationList = new ArrayList<>();

        for (S listItem : sourceList) {
            D resultItem =  mapper.map(listItem, destinationType);
            destinationList.add(resultItem);
        }

        return destinationList;
    }
}
