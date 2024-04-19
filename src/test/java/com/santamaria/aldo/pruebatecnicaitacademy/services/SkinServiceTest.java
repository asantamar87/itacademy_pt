package com.santamaria.aldo.pruebatecnicaitacademy.services;


import com.santamaria.aldo.pruebatecnicaitacademy.models.Skin;
import com.santamaria.aldo.pruebatecnicaitacademy.repositories.ISkinRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class SkinServiceTest {
    @Mock
    private ISkinRepository skinRepository;

    @InjectMocks
    private SkinServiceImpl skinService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);

    }

    @Test
    public void testGetSkins() {
        Skin skin1 = new Skin(/* Datos de prueba */);
        Skin skin2 = new Skin(/* Datos de prueba */);
        List<Skin> skins = Arrays.asList(skin1, skin2);

        when(skinRepository.findAll()).thenReturn(skins);
        List<Skin> result = skinService.getSkins();
        assertEquals(skins, result);
    }



    @Test
    public void testBuySkin() {
        Skin skin = new Skin(/* Datos de prueba */);
        when(skinRepository.save(skin)).thenReturn(skin);
        Skin result = skinService.buySkin(skin);
        assertEquals(skin, result);
    }

    @Test
    public void testGetMySkins() {
        Skin skin1 = new Skin(/* Datos de prueba */);
        Skin skin2 = new Skin(/* Datos de prueba */);
        List<Skin> skins = Arrays.asList(skin1, skin2);

        when(skinRepository.findAll()).thenReturn(skins);
        List<Skin> result = skinService.getMySkins();
        assertEquals(skins, result);
    }

    @Test
    public void testChangeColor() {
        Skin skin = new Skin(/* Datos de prueba */);
        when(skinRepository.save(skin)).thenReturn(skin);
        Skin result = skinService.changeColor(skin);
        assertEquals(skin, result);
    }


}
