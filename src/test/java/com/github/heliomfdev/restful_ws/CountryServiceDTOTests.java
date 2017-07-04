package com.github.heliomfdev.restful_ws;

import com.github.heliomfdev.restful_ws.dto.CountryDTO;
import com.github.heliomfdev.restful_ws.dto.mapper.ListMapper;
import com.github.heliomfdev.restful_ws.dto.mapper.Mapper;
import com.github.heliomfdev.restful_ws.model.Country;
import com.github.heliomfdev.restful_ws.repository.CountryRepository;
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
public class CountryServiceDTOTests {

    @Autowired
    private CountryRepository countryRepository;

    @Test
    public void dtoDataMatchesWithCorrespondingModelData() {
        Country country = countryRepository.findByAbbreviation("BR");

        /* Test with a single object. */
        CountryDTO countryDTO = Mapper.map(country, CountryDTO.class);

        Assert.assertNotNull(country);
        Assert.assertNotNull(countryDTO);
        Assert.assertNotNull(country.getName(), countryDTO.getName());
        Assert.assertNotNull(country.getAbbreviation(), countryDTO.getAbbreviation());

        Assert.assertEquals(country.getName(), countryDTO.getName());
        Assert.assertEquals(country.getAbbreviation(), countryDTO.getAbbreviation());
        Assert.assertEquals(country.getQuantidadeEstados(), countryDTO.getNumberOfStates());

        /* Test with a collection */
        List<Country> listPais = countryRepository.findAll();

        ListMapper<Country, CountryDTO> listMapper = new ListMapper<>();
        List<CountryDTO> listCountryDTO = listMapper.map(listPais, CountryDTO.class);
        Iterator<Country> listPaisIterator = listPais.iterator();
        Iterator<CountryDTO> listDTOIterator = listCountryDTO.iterator();

        while(listPaisIterator.hasNext()) {
            country = listPaisIterator.next();
            countryDTO = listDTOIterator.next();

            Assert.assertNotNull(country);
            Assert.assertNotNull(countryDTO);
            Assert.assertNotNull(country.getName(), countryDTO.getName());
            Assert.assertNotNull(country.getAbbreviation(), countryDTO.getAbbreviation());

            Assert.assertEquals(country.getName(), countryDTO.getName());
            Assert.assertEquals(country.getAbbreviation(), countryDTO.getAbbreviation());
            Assert.assertEquals(country.getQuantidadeEstados(), countryDTO.getNumberOfStates());
        }
    }
}
