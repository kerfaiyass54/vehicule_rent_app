package controllers;


import DTO.RepairDTO;
import DTO.RepairInfoDTO;
import DTO.VehiculeDTO;
import entities.RepairInfo;
import enums.RepairStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import services.RepairInfoService;

import java.time.LocalDate;

@RestController
@RequestMapping("/repairinfo")
@CrossOrigin(origins = "http://localhost:4200")
public class RepairInfoController {

    @Autowired
    private RepairInfoService repairInfoService;

    @PostMapping("/date")
    void updateDateStart(@RequestParam LocalDate date,@RequestBody RepairInfo repairInfo){
        repairInfoService.updateDateStart(date, repairInfo);
    }

    @PostMapping("/status")
    void updateStatus(@RequestBody RepairInfo repairInfo,@RequestParam RepairStatus repairStatus){
        repairInfoService.updateStatus(repairInfo, repairStatus);
    }

    @GetMapping("/get/{id}")
    RepairInfoDTO getRepairInfoById(@PathVariable long id){
        return repairInfoService.getRepairInfoById(id);
    }

    @GetMapping("/vehicule/{name}")
    VehiculeDTO getVehiculeById(@PathVariable String name){
        return repairInfoService.getVehiculeById(name);
    }

    @GetMapping("/repair/{name}")
    RepairDTO getRepair(@PathVariable String name){
        return repairInfoService.getRepair(name);
    }

    @PostMapping("/add/{vehiculeName}")
    void addReparation(@PathVariable String vehiculeName,@RequestParam String repairName,@RequestParam LocalDate date){
        repairInfoService.addReparation(vehiculeName, repairName, date);
    }


}
