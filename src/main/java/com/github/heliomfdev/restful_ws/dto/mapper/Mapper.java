package com.github.heliomfdev.restful_ws.dto.mapper;

import com.github.heliomfdev.restful_ws.dto.CidadeDTO;
import com.github.heliomfdev.restful_ws.model.Cidade;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

public class Mapper {

    private Mapper() {
        /* Singleton should not be instantiated */
    }

    private static ModelMapper modelMapper;

    public static ModelMapper getInstance() {

        if (modelMapper == null) {
            modelMapper = new ModelMapper();

            /* Explicit mapping for Cidade */
            modelMapper.addMappings(new PropertyMap<Cidade, CidadeDTO>() {
                @Override
                protected void configure() {
                    String nomePais = source.getEstado().getPais().getNome();
                    map().setNomePais(nomePais);
                }});
        }

        return modelMapper;
    }
}
