package controllers;


import entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import services.AdminService;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/admin")
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

    @GetMapping("/repairs")
    List<Location> getLocations(){
        return adminService.getLocations();
    }


    @PutMapping("/update-admin")
    void updateDetails(@RequestBody Admin admin){
        adminService.updateDetails(admin);
    }


    @GetMapping("/admin-details/{adminName}")
    Admin getDetails(@PathVariable String adminName){
        return adminService.getDetails(adminName);
    }






}
