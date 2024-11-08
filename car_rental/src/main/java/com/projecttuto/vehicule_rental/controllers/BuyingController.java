package com.projecttuto.vehicule_rental.controllers;


import com.projecttuto.vehicule_rental.entities.Buying;
import com.projecttuto.vehicule_rental.entities.Client;
import com.projecttuto.vehicule_rental.entities.Vehicule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.projecttuto.vehicule_rental.services.BuyingService;

@RestController
@RequestMapping("/buying")
@CrossOrigin("*")
public class BuyingController {

    @Autowired
    private BuyingService buyingService;

    @GetMapping("/details/{id}")
    public Buying getBuyingById(@PathVariable long id){
        return buyingService.getBuyingById(id);
    }

    @GetMapping("/vehicule/{vehicule}")
    public Vehicule getVehicule(@PathVariable String vehicule){
        return buyingService.getVehicule(vehicule);
    }


    @GetMapping("/client/{clientName}")
    public Client getClient(@PathVariable String clientName){
        return buyingService.getClient(clientName);
    }


    @DeleteMapping("/{id}")
    public void deleteBuyingById(@PathVariable long id){
        buyingService.deleteBuyingById(id);
    }

    @PostMapping("/buy/{vehiculeName}")
    public void buyVehicule(@PathVariable String vehiculeName,@RequestParam String clientName,@RequestParam int period){
        buyingService.buyVehicule(vehiculeName,clientName,period);
    }

    @GetMapping("/return/{vehiculeName}")
    public void returnVehicule(@PathVariable String vehiculeName,@RequestParam String clientName){
        buyingService.returnVehicule(vehiculeName,clientName);
    }
}
