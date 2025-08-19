package com.projecttuto.vehicule_rental.controllers;


import com.projecttuto.vehicule_rental.DTO.AdressDTO;
import com.projecttuto.vehicule_rental.entities.Adress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import com.projecttuto.vehicule_rental.services.AdressService;

import java.util.List;

@RestController
@RequestMapping("/adress")
@CrossOrigin("*")
public class AdressController {

    @Autowired
    private AdressService adressService;

    @PostMapping("/free/{adressName}")
    void freeAdress(@PathVariable String adressName){
        adressService.freeAdress(adressName);
    }

    @GetMapping("/adresses")
    List<AdressDTO> getAdresses(){
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
