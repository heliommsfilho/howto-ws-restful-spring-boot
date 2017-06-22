package com.github.heliomfdev.restful_ws;

import com.github.heliomfdev.restful_ws.dto.EstadoDto;
import com.github.heliomfdev.restful_ws.model.Estado;
import com.github.heliomfdev.restful_ws.repository.EstadoRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EstadoDtoTests {

    Estado estado;
    List<Estado> estados;
    EstadoDto estadoDto;
    List<EstadoDto> estadosDto;
    ModelMapper mapper;
    ModelMapper mapperCollection;

    @Autowired
    EstadoRepository estadoRepository;

    @Before
    public void setUp() throws Exception {
        mapper = new ModelMapper();
        mapper.addConverter(new PaisCollectionConverter());
        estado = estadoRepository.findBySigla("BA");
        estadoDto = mapper.map(estado, EstadoDto.class);
        estados = estadoRepository.findAll();
    }

    @Test
    public void dtoDataMachesWithCorrespondingModelData() {
        Assert.assertNotNull(estado);
        Assert.assertNotNull(estadoDto);
        Assert.assertEquals(estado.getPais().getNome(), estadoDto.getNomePais());
        Assert.assertEquals(estado.getNome(), estadoDto.getNome());
        Assert.assertEquals(estado.getSigla(), estadoDto.getSigla());


    }
}
