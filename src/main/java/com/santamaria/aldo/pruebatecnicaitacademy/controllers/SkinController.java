package com.santamaria.aldo.pruebatecnicaitacademy.controllers;


import com.santamaria.aldo.pruebatecnicaitacademy.models.Skin;
import com.santamaria.aldo.pruebatecnicaitacademy.services.SkinServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/skins")
public class SkinController {

    @Autowired
    private SkinServiceImpl skinService;

    // GET /skins/avaible, que devuelva una lista de las skins disponibles para comprar.
    @GetMapping("/avaible")
    public List<Skin> getSkins(){
       // return skinService.getSkins();
        return skinService.leerSkinsDesdeJSON();
    }


    // POST /skins/buy - Permite a los usuarios adquirir una skin y guardarla en la base de datos.
    @PostMapping("/buy")
    public Skin buySkin(Skin skin){
        return skinService.buySkin(skin);
    }


  //  GET /skins/myskins - Devuelve una lista de las skins compradas por el usuario.
    @GetMapping("/myskins")
    public List<Skin> getMySkins() {
        return skinService.getMySkins();
    }

   // PUT /skins/color - Permite a los usuarios cambiar el color de una skin comprada.

    @PutMapping("/color")
    public Skin changeColor(Skin skin){
        return skinService.changeColor(skin);
    }



    // DELETE /skins/delete/{id} - Permite a los usuarios eliminar una skin comprada.
    @DeleteMapping("/delete/{id}")
    public void deleteSkin(@PathVariable Long id){
        skinService.deleteSkin(id);
    }

    // GET /skin/getskin/{id} – Devuelve una skin determinada.
    @GetMapping("/getskin/{id}")
    public Skin getSkin(@PathVariable Long id){
        return skinService.getSkin(id);
    }

}
