package com.santamaria.aldo.pruebatecnicaitacademy.services;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.santamaria.aldo.pruebatecnicaitacademy.models.Skin;
import com.santamaria.aldo.pruebatecnicaitacademy.repositories.ISkinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Service
public class SkinServiceImpl {

    @Autowired
    private ISkinRepository skinRepository;

    public List<Skin> getSkins(){
        return skinRepository.findAll();
    }

    public Skin buySkin(Skin skin) {
        return skinRepository.save(skin);
    }

    public List<Skin> getMySkins(){
        return skinRepository.findAll();
    }

    public Skin changeColor(Skin skin){
        return skinRepository.save(skin);
    }

    public void deleteSkin(Long id){
        skinRepository.deleteById(id);
    }

    public Skin getSkin(Long id){
        return skinRepository.findById(id).get();
    }



    public List<Skin> leerSkinsDesdeJSON() {
        try {
            ClassPathResource resource = new ClassPathResource("data/skins.json");

            // Mapear el contenido del archivo JSON a una lista de objetos Skin
            ObjectMapper mapper = new ObjectMapper();
            Skin[] skinsArray = mapper.readValue(resource.getInputStream(), Skin[].class);
            return Arrays.asList(skinsArray);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }


    }


}
