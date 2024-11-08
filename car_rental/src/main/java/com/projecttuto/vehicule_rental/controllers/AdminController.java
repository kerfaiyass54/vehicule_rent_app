package com.projecttuto.vehicule_rental.controllers;


import com.projecttuto.vehicule_rental.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.projecttuto.vehicule_rental.services.AdminService;

import java.util.List;

@RestController
@RequestMapping("/admin")
@CrossOrigin("*")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/clients")
    public List<Client> getClients(){
        return adminService.getClients();
    }

    @GetMapping("/suppliers")
    public List<Supplier> getSuppliers(){
        return adminService.getSuppliers();
    }

    @GetMapping("/repairs")
    public List<Repair> getRepairs(){
        return adminService.getRepairs();
    }

    @GetMapping("/locations")
    public List<Location> getLocations(){
        return adminService.getLocations();
    }


    @PutMapping("/update-admin")
    public void updateDetails(@RequestBody Admin admin){
        adminService.updateDetails(admin);
    }


    @GetMapping("/admin-details/{adminName}")
    public Admin getDetails(@PathVariable String adminName){
        return adminService.getDetails(adminName);
    }






}
