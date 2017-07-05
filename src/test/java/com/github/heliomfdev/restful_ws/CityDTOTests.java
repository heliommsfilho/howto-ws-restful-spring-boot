package com.github.heliomfdev.restful_ws;

import com.github.heliomfdev.restful_ws.dto.CityDTO;
import com.github.heliomfdev.restful_ws.dto.mapper.ListMapper;
import com.github.heliomfdev.restful_ws.model.City;
import com.github.heliomfdev.restful_ws.repository.CityRepository;
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
public class CityDTOTests {

    @Autowired
    private CityRepository cityRepository;

    @Test
    public void dtoDataMatchesWithCorrespondingModelData() {
        final int QUANTIDADE_CIDADES_SAO_PAULO = 645;

        ListMapper<City, CityDTO> listMapper = new ListMapper<>();

        /* Test findByNameContaining() */
        List<City> listCities = cityRepository.findByNameContaining("são");
        List<CityDTO> listCidadesDTO = listMapper.map(listCities, CityDTO.class);

        Iterator<City> iteratorListCidades = listCities.iterator();
        Iterator<CityDTO> iteratorListCidadesDTO = listCidadesDTO.iterator();

        while(iteratorListCidades.hasNext()) {
            City city = iteratorListCidades.next();
            CityDTO cityDTO = iteratorListCidadesDTO.next();

            Assert.assertNotNull(city);
            Assert.assertNotNull(cityDTO);
            Assert.assertNotNull(city.getState().getCountry().getName());
            Assert.assertNotNull(city.getState().getName());
            Assert.assertNotNull(city.getName());
            Assert.assertNotNull(cityDTO.getCountryName());
            Assert.assertNotNull(cityDTO.getStateName());
            Assert.assertNotNull(cityDTO.getCityName());
            Assert.assertEquals(city.getState().getCountry().getName(), cityDTO.getCountryName());
            Assert.assertEquals(city.getState().getName(), cityDTO.getStateName());
            Assert.assertEquals(city.getName(), cityDTO.getCityName());
        }

        /* Test findByState_Abbreviation(). */
        listCities = cityRepository.findByState_Abbreviation("SP");
        listCidadesDTO = listMapper.map(listCities, CityDTO.class);

        iteratorListCidades = listCities.iterator();
        iteratorListCidadesDTO = listCidadesDTO.iterator();

        while(iteratorListCidades.hasNext()) {
            City city = iteratorListCidades.next();
            CityDTO cityDTO = iteratorListCidadesDTO.next();

            Assert.assertNotNull(city);
            Assert.assertNotNull(cityDTO);
            Assert.assertNotNull(city.getState().getCountry().getName());
            Assert.assertNotNull(city.getState().getName());
            Assert.assertNotNull(city.getName());
            Assert.assertNotNull(cityDTO.getCountryName());
            Assert.assertNotNull(cityDTO.getStateName());
            Assert.assertNotNull(cityDTO.getCityName());
            Assert.assertEquals(city.getState().getCountry().getName(), cityDTO.getCountryName());
            Assert.assertEquals(city.getState().getName(), cityDTO.getStateName());
            Assert.assertEquals(city.getName(), cityDTO.getCityName());
            Assert.assertEquals(listCities.size(), QUANTIDADE_CIDADES_SAO_PAULO);
            Assert.assertEquals(listCities.size(), listCidadesDTO.size());

            System.out.println(cityDTO.getCountryName());
            System.out.println(cityDTO.getStateName());
            System.out.println(cityDTO.getCityName());
            System.out.printf("\n\n");
        }

        // de novo
        listCidadesDTO = listMapper.map(listCities, CityDTO.class);
        iteratorListCidades = listCities.iterator();
        iteratorListCidadesDTO = listCidadesDTO.iterator();

        while(iteratorListCidades.hasNext()) {
            City city = iteratorListCidades.next();
            CityDTO cityDTO = iteratorListCidadesDTO.next();

            Assert.assertNotNull(city);
            Assert.assertNotNull(cityDTO);
            Assert.assertNotNull(city.getState().getCountry().getName());
            Assert.assertNotNull(city.getState().getName());
            Assert.assertNotNull(city.getName());
            Assert.assertNotNull(cityDTO.getCountryName());
            Assert.assertNotNull(cityDTO.getStateName());
            Assert.assertNotNull(cityDTO.getCityName());
            Assert.assertEquals(city.getState().getCountry().getName(), cityDTO.getCountryName());
            Assert.assertEquals(city.getState().getName(), cityDTO.getStateName());
            Assert.assertEquals(city.getName(), cityDTO.getCityName());
            Assert.assertEquals(listCities.size(), QUANTIDADE_CIDADES_SAO_PAULO);
            Assert.assertEquals(listCities.size(), listCidadesDTO.size());

            System.out.println("Denovo" + cityDTO.getCountryName());
            System.out.println("Denovo" + cityDTO.getStateName());
            System.out.println("Denovo" + cityDTO.getCityName());
            System.out.printf("\n\n");
        }

        // de novo
        listCidadesDTO = listMapper.map(listCities, CityDTO.class);
        iteratorListCidades = listCities.iterator();
        iteratorListCidadesDTO = listCidadesDTO.iterator();

        while(iteratorListCidades.hasNext()) {
            City city = iteratorListCidades.next();
            CityDTO cityDTO = iteratorListCidadesDTO.next();

            Assert.assertNotNull(city);
            Assert.assertNotNull(cityDTO);
            Assert.assertNotNull(city.getState().getCountry().getName());
            Assert.assertNotNull(city.getState().getName());
            Assert.assertNotNull(city.getName());
            Assert.assertNotNull(cityDTO.getCountryName());
            Assert.assertNotNull(cityDTO.getStateName());
            Assert.assertNotNull(cityDTO.getCityName());
            Assert.assertEquals(city.getState().getCountry().getName(), cityDTO.getCountryName());
            Assert.assertEquals(city.getState().getName(), cityDTO.getStateName());
            Assert.assertEquals(city.getName(), cityDTO.getCityName());
            Assert.assertEquals(listCities.size(), QUANTIDADE_CIDADES_SAO_PAULO);
            Assert.assertEquals(listCities.size(), listCidadesDTO.size());

            System.out.println("Denovo" + cityDTO.getCountryName());
            System.out.println("Denovo" + cityDTO.getStateName());
            System.out.println("Denovo" + cityDTO.getCityName());
            System.out.printf("\n\n");
        }
    }
}
