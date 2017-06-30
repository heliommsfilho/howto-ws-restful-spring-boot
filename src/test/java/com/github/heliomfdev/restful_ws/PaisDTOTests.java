package com.github.heliomfdev.restful_ws;

import com.github.heliomfdev.restful_ws.dto.PaisDTO;
import com.github.heliomfdev.restful_ws.dto.mapper.ListMapper;
import com.github.heliomfdev.restful_ws.dto.mapper.Mapper;
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

import javax.transaction.Transactional;
import java.util.Iterator;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class PaisDTOTests {

    @Autowired
    private PaisRepository paisRepository;

    @Test
    public void dtoDataMatchesWithCorrespondingModelData() {
        Pais pais = paisRepository.findBySigla("BR");

        /* Test with a single object. */
        PaisDTO paisDTO = Mapper.map(pais, PaisDTO.class);

        Assert.assertNotNull(pais);
        Assert.assertNotNull(paisDTO);
        Assert.assertNotNull(pais.getNome(), paisDTO.getNome());
        Assert.assertNotNull(pais.getSigla(), paisDTO.getSigla());

        Assert.assertEquals(pais.getNome(), paisDTO.getNome());
        Assert.assertEquals(pais.getSigla(), paisDTO.getSigla());
        Assert.assertEquals(pais.getQuantidadeEstados(), paisDTO.getQuantidadeEstados());

        /* Test with a collection */
        List<Pais> listPais = paisRepository.findAll();

        ListMapper<Pais, PaisDTO> listMapper = new ListMapper<>();
        List<PaisDTO> listPaisDTO = listMapper.map(listPais, PaisDTO.class);
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
