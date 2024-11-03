package com.projecttuto.vehicule_rental.controllers;

import com.projecttuto.vehicule_rental.DTO.SupplierDTO;
import com.projecttuto.vehicule_rental.entities.Adress;
import com.projecttuto.vehicule_rental.entities.Subscription;
import com.projecttuto.vehicule_rental.entities.Supplier;
import com.projecttuto.vehicule_rental.entities.Vehicule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.projecttuto.vehicule_rental.services.SupplierService;

import java.util.List;

@RestController
@RequestMapping("/supp")

public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @PostMapping("/add")
    public void addSupplier(@RequestBody Supplier supplier){
        supplierService.addSupplier(supplier);
    }

    @PutMapping("/update")
    public void updateSupplier(@RequestBody Supplier supplier){
        supplierService.updateSupplier(supplier);
    }

    @DeleteMapping("/delete")
    public void deleteSupplier(@RequestBody Supplier supplier){
        supplierService.deleteSupplier(supplier);
    }

    @GetMapping("/supplier/{supplierName}")
    public SupplierDTO getSupplier(@PathVariable("supplierName") String supplierName){
        return supplierService.getSupplier(supplierName);
    }

    @PostMapping("/password")
    public void changeSupplierPassword(@RequestBody Supplier supplier,@RequestParam String newPassword){
        supplierService.changeSupplierPassword(supplier,newPassword);
    }

    @GetMapping("/subs")
    public List<Subscription> getSubscriptions(Supplier supplier){
        return supplierService.getSubscriptions(supplier);
    }

    @GetMapping("/adr")
    public List<Adress> getAdresses(Supplier supplier){
        return supplierService.getAdresses(supplier);
    }

    @GetMapping("/veh")
    public List<Vehicule> getVehicules(Supplier supplier){
        return supplierService.getVehicules(supplier);
    }


}
