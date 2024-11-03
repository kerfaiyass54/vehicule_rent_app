package controllers;


import entities.Vehicule;
import enums.CategoryName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import services.VehiculeService;

@RestController
@RequestMapping("/vehicule")
@CrossOrigin(origins = "http://localhost:4200")
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
