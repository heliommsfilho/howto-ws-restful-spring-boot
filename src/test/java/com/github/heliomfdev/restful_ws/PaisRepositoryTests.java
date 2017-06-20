package com.github.heliomfdev.restful_ws;

import com.github.heliomfdev.restful_ws.model.Pais;
import com.github.heliomfdev.restful_ws.repository.PaisRepository;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PaisRepositoryTests extends TestCase {

    @Autowired
    private static PaisRepository paisRepository;


}
