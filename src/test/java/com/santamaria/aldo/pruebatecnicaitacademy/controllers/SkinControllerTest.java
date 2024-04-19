package com.santamaria.aldo.pruebatecnicaitacademy.controllers;


import com.santamaria.aldo.pruebatecnicaitacademy.models.Skin;
import com.santamaria.aldo.pruebatecnicaitacademy.services.SkinServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;

import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
public class SkinControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @InjectMocks
    private SkinController skinController;

    @Mock
    private SkinServiceImpl skinService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void testGetAllSkins() throws Exception {
        // Mock de los datos de las skins
    Skin skin1 = new Skin();
    Skin skin2 = new Skin();

        when(skinService.leerSkinsDesdeJSON()).thenReturn(Arrays.asList(skin1, skin2));

        // Prueba de la solicitud HTTP GET /skins/avaible
        mockMvc.perform(MockMvcRequestBuilders.get("/skins/avaible"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name").value("Skin1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].type").value("Type1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].name").value("Skin2"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].type").value("Type2"));
    }
}
