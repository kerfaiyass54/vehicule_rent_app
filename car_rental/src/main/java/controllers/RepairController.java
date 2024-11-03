package controllers;


import DTO.LocationDTO;
import DTO.RepairDTO;
import entities.Repair;
import entities.RepairInfo;
import entities.Ticket;
import entities.Vehicule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import services.RepairService;

import java.util.List;

@RestController
@RequestMapping("/repair")
@CrossOrigin(origins = "http://localhost:4200")
public class RepairController {

    @Autowired
    private RepairService repairService;

    @PostMapping("/add")
    void addRepair(@RequestBody Repair repair){
        repairService.addRepair(repair);
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
