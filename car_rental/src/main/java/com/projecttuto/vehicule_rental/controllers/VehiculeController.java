package com.projecttuto.vehicule_rental.controllers;


import com.projecttuto.vehicule_rental.entities.Vehicule;
import com.projecttuto.vehicule_rental.enums.CategoryName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.projecttuto.vehicule_rental.services.VehiculeService;

@RestController
@RequestMapping("/vehicule")
@CrossOrigin("*")
public class VehiculeController {

    @Autowired
    private VehiculeService vehiculeService;

    @PostMapping("/adding/{nameSupplier}")
    public void addVehicule(@RequestBody Vehicule vehicule,@PathVariable String nameSupplier,@RequestParam CategoryName nameCategory){
        vehiculeService.addVehicule(vehicule, nameSupplier, nameCategory);
    }

    @DeleteMapping("/delete")
    public void deleteVehicule(@RequestBody Vehicule vehicule){
        vehiculeService.deleteVehicule(vehicule);
    }

    @PutMapping("/update")
    public void updateVehicule(@RequestBody Vehicule vehicule){
        vehiculeService.updateVehicule(vehicule);
    }



}
