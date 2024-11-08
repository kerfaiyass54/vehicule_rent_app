package com.projecttuto.vehicule_rental.controllers;


import com.projecttuto.vehicule_rental.DTO.LocationDTO;
import com.projecttuto.vehicule_rental.DTO.RepairDTO;
import com.projecttuto.vehicule_rental.entities.Repair;
import com.projecttuto.vehicule_rental.entities.RepairInfo;
import com.projecttuto.vehicule_rental.entities.Ticket;
import com.projecttuto.vehicule_rental.entities.Vehicule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.projecttuto.vehicule_rental.services.RepairService;

import java.util.List;

@RestController
@RequestMapping("/repair")
@CrossOrigin("*")
public class RepairController {

    @Autowired
    private RepairService repairService;

    @PostMapping("/add")
    void addRepair(@RequestBody Repair repair, @RequestParam String location) {
        repairService.addRepair(repair,location);
    }

    @PostMapping("/delete")
    void deleteRepair(@RequestBody Repair repair){
        repairService.deleteRepair(repair);
    }

    @PutMapping("/update")
    void updateRepair(@RequestBody Repair repair){
        repairService.updateRepair(repair);
    }

    @GetMapping("/{nameRepair}/get")
    RepairDTO getRepair(@PathVariable String nameRepair){
        return repairService.getRepair(nameRepair);
    }

    @PostMapping("/pass")
    void changeRepairPassword(@RequestBody Repair repair,@RequestParam String newPassword){
        repairService.changeRepairPassword(repair, newPassword);
    }

    @GetMapping("/tickets/{repairName}")
    List<Ticket> getTickets(@PathVariable String repairName){
        return repairService.getTickets(repairName);
    }

    @GetMapping("/repairinfos/{repairName}")
    List<RepairInfo> getRepairInfo(@PathVariable String repairName){
        return repairService.getRepairInfo(repairName);
    }

    @GetMapping("/vehicules/{repairName}")
    List<Vehicule> getVehicules(@PathVariable String repairName){
        return repairService.getVehicules(repairName);
    }

    @PostMapping("/changeloc/{repairName}")
    void updateLocation(@PathVariable String repairName,@RequestParam String locationName){
        repairService.updateLocation(repairName, locationName);
    }

    @GetMapping("/location/{locationName}")
    LocationDTO getLocation(@PathVariable String locationName){
        return repairService.getLocation(locationName);
    }
}
