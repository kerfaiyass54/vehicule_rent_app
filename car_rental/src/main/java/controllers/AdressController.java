package controllers;


import entities.Adress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import services.AdressService;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/adress")
public class AdressController {

    @Autowired
    private AdressService adressService;

    @PostMapping("/free/{adressName}")
    void freeAdress(@PathVariable String adressName){
        adressService.freeAdress(adressName);
    }

    @GetMapping("/adresses")
    List<Adress> getAdresses(){
        return adressService.getAdresses();
    }

    @PostMapping("/add")
    void addAdress(@RequestBody Adress adress){
        adressService.addAdress(adress);
    }

    @DeleteMapping("/delete/{adressName}")
    void deleteAdress(@PathVariable String adressName){
        adressService.deleteAdress(adressName);
    }

    @PutMapping("/update/{adressName}")
    void updateAdress(@PathVariable String adressName){
        adressService.updateAdress(adressName);
    }
}
