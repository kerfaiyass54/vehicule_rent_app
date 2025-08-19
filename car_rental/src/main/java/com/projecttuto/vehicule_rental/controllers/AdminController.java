package com.projecttuto.vehicule_rental.controllers;


import com.projecttuto.vehicule_rental.DTO.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.projecttuto.vehicule_rental.services.AdminService;
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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.DeleteMapping;





import java.util.List;

@RestController
@RequestMapping("/admin")
@CrossOrigin("*")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/clients")
    public List<ClientDTO> getClients(){
        return adminService.getClients();
    }


    @GetMapping("/suppliers")
    public List<SupplierDTO> getSuppliers(){
        return adminService.getSuppliers();
    }

    @GetMapping("/repairs")
    public List<RepairDTO> getRepairs(){
        return adminService.getRepairs();
    }

    @GetMapping("/locations")
    public List<LocationDTO> getLocations(){
        return adminService.getLocations();
    }


    @PutMapping("/update-admin")
    public void updateDetails(@RequestBody AdminDTO adminDTO){
        adminService.updateDetails(adminDTO);
    }


    @GetMapping("/admin-details/{adminName}")
    public AdminDTO getDetails(@PathVariable String adminName){
        return adminService.getDetails(adminName);
    }

    @GetMapping("/names")
    public List<String> getNames(){
        return adminService.getNames();
    }






}
