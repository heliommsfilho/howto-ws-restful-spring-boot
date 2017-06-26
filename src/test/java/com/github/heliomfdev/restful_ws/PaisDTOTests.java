package com.github.heliomfdev.restful_ws;

import com.github.heliomfdev.restful_ws.dto.PaisDTO;
import com.github.heliomfdev.restful_ws.dto.mapper.CollectionMapper;
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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PaisDTOTests {

    ModelMapper mapper;

    @Autowired
    PaisRepository repository;

    @Before
    public void setUp() throws Exception {
       mapper = new ModelMapper();
    }

    @Test
    public void dtoDataMachesWithCorrespondingModelData() {
        Pais pais = repository.findBySigla("BR");
        PaisDTO paisDTO = mapper.map(pais, PaisDTO.class);

        Assert.assertNotNull(pais);
        Assert.assertNotNull(paisDTO);
        Assert.assertNotNull(pais.getNome(), paisDTO.getNome());
        Assert.assertNotNull(pais.getSigla(), paisDTO.getSigla());

        Assert.assertEquals(pais.getNome(), paisDTO.getNome());
        Assert.assertEquals(pais.getSigla(), paisDTO.getSigla());
        Assert.assertEquals(pais.getQuantidadeEstados(), paisDTO.getQuantidadeEstados());

        List<Pais> listPais = repository.findAll();

        CollectionMapper<Pais, PaisDTO> collectionMapper = new CollectionMapper<>();
        List<PaisDTO> listPaisDTO = collectionMapper.map(listPais, PaisDTO.class);
        Iterator<Pais> listPaisIterator = listPais.iterator();
        Iterator<PaisDTO> listDTOIterator = listPaisDTO.iterator();

        while(listPaisIterator.hasNext()) {
            pais = listPaisIterator.next();
            paisDTO = listDTOIterator.next();

            Assert.assertNotNull(pais);
            Assert.assertNotNull(paisDTO);
            Assert.assertNotNull(pais.getNome(), paisDTO.getNome());
            Assert.assertNotNull(pais.getSigla(), paisDTO.getSigla());

            Assert.assertEquals(pais.getNome(), paisDTO.getNome());
            Assert.assertEquals(pais.getSigla(), paisDTO.getSigla());
            Assert.assertEquals(pais.getQuantidadeEstados(), paisDTO.getQuantidadeEstados());
        }
    }
}
