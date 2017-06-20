package com.github.heliomfdev.restful_ws.dto;

import org.modelmapper.ModelMapper;

public class Mapper {

    private Mapper() {
        /* Singleton should not be instantiated */
    }

    private static ModelMapper modelMapper;

    public static ModelMapper getInstance() {

        if (modelMapper == null) {
            modelMapper = new ModelMapper();
        }

        return modelMapper;
    }
}
