package com.github.heliomfdev.restful_ws;

import com.github.heliomfdev.restful_ws.dto.EstadoDTO;
import com.github.heliomfdev.restful_ws.dto.mapper.ListMapper;
import com.github.heliomfdev.restful_ws.dto.mapper.Mapper;
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

import javax.transaction.Transactional;
import java.util.Iterator;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class EstadoDTOTests {

    @Autowired
    private EstadoRepository estadoRepository;

    @Test
    public void dtoDataMatchesWithCorrespondingModelData() {
        final Integer QUANTIDADE_CIDADES_BAHIA = 417;
        final int QUANTIDADE_ESTADOS_CONTAINING_GRANDE = 2;
        final int QUANTIDADE_ESTADOS_BRASIL = 27;

        Estado estado = estadoRepository.findBySigla("BA");

        /* Test findBySigla(). */
        EstadoDTO estadoDTO = Mapper.map(estado, EstadoDTO.class);

        Assert.assertNotNull(estado);
        Assert.assertNotNull(estadoDTO);
        Assert.assertNotNull(estado.getNome());
        Assert.assertNotNull(estado.getSigla());
        Assert.assertNotNull(estado.getPais().getNome());
        Assert.assertNotNull(estadoDTO.getNome());
        Assert.assertNotNull(estadoDTO.getSigla());
        Assert.assertNotNull(estadoDTO.getNome());
        Assert.assertEquals(estado.getNome(), estadoDTO.getNome());
        Assert.assertEquals(estado.getSigla(), estadoDTO.getSigla());
        Assert.assertEquals(estado.getPais().getNome(), estadoDTO.getNomePais());
        Assert.assertEquals(estado.getQuantidadeCidades(), QUANTIDADE_CIDADES_BAHIA);

        /* Test findByNomeContaining(). */
        ListMapper<Estado, EstadoDTO> listMapper = new ListMapper<>();

        List<Estado> listEstados = estadoRepository.findByNomeContaining("Grande");
        List<EstadoDTO> listEstadosDTO = listMapper.map(listEstados, EstadoDTO.class);
        Iterator<Estado> iteratorListEstados = listEstados.iterator();
        Iterator<EstadoDTO> iteratorListEstadosDTO = listEstadosDTO.iterator();

        while(iteratorListEstados.hasNext()) {
            estado = iteratorListEstados.next();
            estadoDTO = iteratorListEstadosDTO.next();

            Assert.assertNotNull(estado);
            Assert.assertNotNull(estadoDTO);
            Assert.assertNotNull(estado.getNome());
            Assert.assertNotNull(estado.getSigla());
            Assert.assertNotNull(estado.getPais().getNome());
            Assert.assertNotNull(estado.getQuantidadeCidades());
            Assert.assertNotNull(estadoDTO.getNome());
            Assert.assertNotNull(estadoDTO.getSigla());
            Assert.assertNotNull(estadoDTO.getNome());
            Assert.assertNotNull(estadoDTO.getQuantidadeCidades());
            Assert.assertEquals(estado.getNome(), estadoDTO.getNome());
            Assert.assertEquals(estado.getSigla(), estadoDTO.getSigla());
            Assert.assertEquals(estado.getPais().getNome(), estadoDTO.getNomePais());
            Assert.assertEquals(listEstados.size(), QUANTIDADE_ESTADOS_CONTAINING_GRANDE);
            Assert.assertEquals(estado.getQuantidadeCidades(), estadoDTO.getQuantidadeCidades());
        }

        /* Test findByPais_Sigla(). */
        listEstados = estadoRepository.findByPais_Sigla("BR");
        listEstadosDTO = listMapper.map(listEstados, EstadoDTO.class);
        iteratorListEstados = listEstados.iterator();
        iteratorListEstadosDTO = listEstadosDTO.iterator();

        while(iteratorListEstados.hasNext()) {
            estado = iteratorListEstados.next();
            estadoDTO = iteratorListEstadosDTO.next();

            Assert.assertNotNull(estado);
            Assert.assertNotNull(estadoDTO);
            Assert.assertNotNull(estado.getNome());
            Assert.assertNotNull(estado.getSigla());
            Assert.assertNotNull(estado.getPais().getNome());
            Assert.assertNotNull(estado.getQuantidadeCidades());
            Assert.assertNotNull(estadoDTO.getNome());
            Assert.assertNotNull(estadoDTO.getSigla());
            Assert.assertNotNull(estadoDTO.getNome());
            Assert.assertNotNull(estadoDTO.getQuantidadeCidades());
            Assert.assertEquals(estado.getNome(), estadoDTO.getNome());
            Assert.assertEquals(estado.getSigla(), estadoDTO.getSigla());
            Assert.assertEquals(estado.getPais().getNome(), estadoDTO.getNomePais());
            Assert.assertEquals(listEstados.size(), QUANTIDADE_ESTADOS_BRASIL);
            Assert.assertEquals(estado.getQuantidadeCidades(), estadoDTO.getQuantidadeCidades());
        }
    }
}
