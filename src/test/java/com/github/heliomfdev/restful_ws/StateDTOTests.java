package com.github.heliomfdev.restful_ws;

import com.github.heliomfdev.restful_ws.dto.StateDTO;
import com.github.heliomfdev.restful_ws.dto.mapper.ListMapper;
import com.github.heliomfdev.restful_ws.dto.mapper.Mapper;
import com.github.heliomfdev.restful_ws.model.State;
import com.github.heliomfdev.restful_ws.repository.StateRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.Iterator;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class StateDTOTests {

    @Autowired
    private StateRepository stateRepository;

    @Test
    public void dtoDataMatchesWithCorrespondingModelData() {
        final Integer QUANTIDADE_CIDADES_BAHIA = 417;
        final int QUANTIDADE_ESTADOS_CONTAINING_GRANDE = 2;
        final int QUANTIDADE_ESTADOS_BRASIL = 27;

        State state = stateRepository.findByAbbreviation("BA");

        /* Test findByAbbreviation(). */
        StateDTO stateDTO = Mapper.map(state, StateDTO.class);

        Assert.assertNotNull(state);
        Assert.assertNotNull(stateDTO);
        Assert.assertNotNull(state.getName());
        Assert.assertNotNull(state.getAbbreviation());
        Assert.assertNotNull(state.getCountry().getName());
        Assert.assertNotNull(stateDTO.getName());
        Assert.assertNotNull(stateDTO.getAbbreviation());
        Assert.assertNotNull(stateDTO.getName());
        Assert.assertEquals(state.getName(), stateDTO.getName());
        Assert.assertEquals(state.getAbbreviation(), stateDTO.getAbbreviation());
        Assert.assertEquals(state.getCountry().getName(), stateDTO.getCountryName());
        Assert.assertEquals(state.getQuantidadeCidades(), QUANTIDADE_CIDADES_BAHIA);

        /* Test findByNameContaining(). */
        ListMapper<State, StateDTO> listMapper = new ListMapper<>();

        List<State> listStates = stateRepository.findByNameContaining("Grande");
        List<StateDTO> listEstadosDTO = listMapper.map(listStates, StateDTO.class);
        Iterator<State> iteratorListEstados = listStates.iterator();
        Iterator<StateDTO> iteratorListEstadosDTO = listEstadosDTO.iterator();

        while(iteratorListEstados.hasNext()) {
            state = iteratorListEstados.next();
            stateDTO = iteratorListEstadosDTO.next();

            Assert.assertNotNull(state);
            Assert.assertNotNull(stateDTO);
            Assert.assertNotNull(state.getName());
            Assert.assertNotNull(state.getAbbreviation());
            Assert.assertNotNull(state.getCountry().getName());
            Assert.assertNotNull(state.getQuantidadeCidades());
            Assert.assertNotNull(stateDTO.getName());
            Assert.assertNotNull(stateDTO.getAbbreviation());
            Assert.assertNotNull(stateDTO.getName());
            Assert.assertNotNull(stateDTO.getNumberOfCities());
            Assert.assertEquals(state.getName(), stateDTO.getName());
            Assert.assertEquals(state.getAbbreviation(), stateDTO.getAbbreviation());
            Assert.assertEquals(state.getCountry().getName(), stateDTO.getCountryName());
            Assert.assertEquals(listStates.size(), QUANTIDADE_ESTADOS_CONTAINING_GRANDE);
            Assert.assertEquals(state.getQuantidadeCidades(), stateDTO.getNumberOfCities());
        }

        /* Test findByCountry_Abbreviation(). */
        listStates = stateRepository.findByCountry_Abbreviation("BR");
        listEstadosDTO = listMapper.map(listStates, StateDTO.class);
        iteratorListEstados = listStates.iterator();
        iteratorListEstadosDTO = listEstadosDTO.iterator();

        while(iteratorListEstados.hasNext()) {
            state = iteratorListEstados.next();
            stateDTO = iteratorListEstadosDTO.next();

            Assert.assertNotNull(state);
            Assert.assertNotNull(stateDTO);
            Assert.assertNotNull(state.getName());
            Assert.assertNotNull(state.getAbbreviation());
            Assert.assertNotNull(state.getCountry().getName());
            Assert.assertNotNull(state.getQuantidadeCidades());
            Assert.assertNotNull(stateDTO.getName());
            Assert.assertNotNull(stateDTO.getAbbreviation());
            Assert.assertNotNull(stateDTO.getName());
            Assert.assertNotNull(stateDTO.getNumberOfCities());
            Assert.assertEquals(state.getName(), stateDTO.getName());
            Assert.assertEquals(state.getAbbreviation(), stateDTO.getAbbreviation());
            Assert.assertEquals(state.getCountry().getName(), stateDTO.getCountryName());
            Assert.assertEquals(listStates.size(), QUANTIDADE_ESTADOS_BRASIL);
            Assert.assertEquals(state.getQuantidadeCidades(), stateDTO.getNumberOfCities());
        }
    }
}
