package com.projecttuto.vehicule_rental.controllers;


import com.projecttuto.vehicule_rental.entities.Vehicule;
import com.projecttuto.vehicule_rental.enums.CategoryName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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
