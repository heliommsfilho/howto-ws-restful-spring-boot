package com.github.heliomfdev.restful_ws.dto.mapper;

import com.github.heliomfdev.restful_ws.dto.CidadeDTO;
import com.github.heliomfdev.restful_ws.model.Cidade;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

public class Mapper {


    private Mapper() {
        /* Should not be instantiated */
    }

    @SuppressWarnings("unchecked")
    public static <S, D> D map(S source, Class<D> destinationType) {

        ModelMapper modelMapper = new ModelMapper();

        /* Explicit mapping for Cidade */
        modelMapper.addMappings(new PropertyMap<Cidade, CidadeDTO>() {
            @Override
            protected void configure() {
                String nomePais = source.getEstado().getPais().getNome();
                map().setNomePais(nomePais);
            }});

        return source != null ? modelMapper.map(source, destinationType) : null;
    }
}