package com.github.heliomfdev.restful_ws;

import com.github.heliomfdev.restful_ws.dto.PaisDto;
import com.github.heliomfdev.restful_ws.model.Pais;
import com.github.heliomfdev.restful_ws.repository.PaisRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PaisDtoTests {

    Pais pais;
    PaisDto paisDto;
    ModelMapper mapper;

    @Autowired
    PaisRepository repository;

    @Before
    public void setUp() throws Exception {
       mapper = new ModelMapper();
    }

    @Test
    public void dtoDataMachesWithCorrespondingModelData() {
        pais = repository.findBySigla("BR");
        paisDto = mapper.map(pais, PaisDto.class);

        Assert.assertNotNull(pais);
        Assert.assertNotNull(paisDto);
        Assert.assertEquals(pais.getNome(), paisDto.getNome());
        Assert.assertEquals(pais.getSigla(), paisDto.getSigla());
        Assert.assertEquals(pais.getQuantidadeEstados(), paisDto.getQuantidadeEstados());
    }
}
