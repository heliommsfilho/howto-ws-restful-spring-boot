package com.github.heliomfdev.restful_ws;

import com.github.heliomfdev.restful_ws.dto.CidadeDTO;
import com.github.heliomfdev.restful_ws.dto.mapper.ListMapper;
import com.github.heliomfdev.restful_ws.dto.mapper.Mapper;
import com.github.heliomfdev.restful_ws.model.Cidade;
import com.github.heliomfdev.restful_ws.repository.CidadeRepository;
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
public class CidadeDTOTests {

    private ModelMapper mapper;

    @Autowired
    private CidadeRepository cidadeRepository;

    @Before
    public void setUp() throws Exception {
        mapper = Mapper.getInstance();
    }

    @Test
    public void dtoDataMatchesWithCorrespondingModelData() {
        final int QUANTIDADE_CIDADES_SAO_PAULO = 645;

        ListMapper<Cidade, CidadeDTO> listMapper = new ListMapper<>();

        /* Test findByNomeContaining() */
        List<Cidade> listCidades = cidadeRepository.findByNomeContaining("são");
        List<CidadeDTO> listCidadesDTO = listMapper.map(listCidades, CidadeDTO.class);

        Iterator<Cidade> iteratorListCidades = listCidades.iterator();
        Iterator<CidadeDTO> iteratorListCidadesDTO = listCidadesDTO.iterator();

        while(iteratorListCidades.hasNext()) {
            Cidade cidade = iteratorListCidades.next();
            CidadeDTO cidadeDTO = iteratorListCidadesDTO.next();

            Assert.assertNotNull(cidade);
            Assert.assertNotNull(cidadeDTO);
            Assert.assertNotNull(cidade.getEstado().getPais().getNome());
            Assert.assertNotNull(cidade.getEstado().getNome());
            Assert.assertNotNull(cidade.getNome());
            Assert.assertNotNull(cidadeDTO.getNomePais());
            Assert.assertNotNull(cidadeDTO.getNomeEstado());
            Assert.assertNotNull(cidadeDTO.getNome());
            Assert.assertEquals(cidade.getEstado().getPais().getNome(), cidadeDTO.getNomePais());
            Assert.assertEquals(cidade.getEstado().getNome(), cidadeDTO.getNomeEstado());
            Assert.assertEquals(cidade.getNome(), cidadeDTO.getNome());
        }

        /* Test findByEstado_Sigla(). */
        listCidades = cidadeRepository.findByEstado_Sigla("SP");
        listCidadesDTO = listMapper.map(listCidades, CidadeDTO.class);

        iteratorListCidades = listCidades.iterator();
        iteratorListCidadesDTO = listCidadesDTO.iterator();

        while(iteratorListCidades.hasNext()) {
            Cidade cidade = iteratorListCidades.next();
            CidadeDTO cidadeDTO = iteratorListCidadesDTO.next();

            Assert.assertNotNull(cidade);
            Assert.assertNotNull(cidadeDTO);
            Assert.assertNotNull(cidade.getEstado().getPais().getNome());
            Assert.assertNotNull(cidade.getEstado().getNome());
            Assert.assertNotNull(cidade.getNome());
            Assert.assertNotNull(cidadeDTO.getNomePais());
            Assert.assertNotNull(cidadeDTO.getNomeEstado());
            Assert.assertNotNull(cidadeDTO.getNome());
            Assert.assertEquals(cidade.getEstado().getPais().getNome(), cidadeDTO.getNomePais());
            Assert.assertEquals(cidade.getEstado().getNome(), cidadeDTO.getNomeEstado());
            Assert.assertEquals(cidade.getNome(), cidadeDTO.getNome());
            Assert.assertEquals(listCidades.size(), QUANTIDADE_CIDADES_SAO_PAULO);
            Assert.assertEquals(listCidades.size(), listCidadesDTO.size());
        }
    }
}
