package services;

import DTO.RepairDTO;
import DTO.RepairInfoDTO;
import DTO.VehiculeDTO;
import entities.Repair;
import entities.RepairInfo;
import entities.Vehicule;
import enums.RepairStatus;

import java.time.LocalDate;
import java.util.Date;

public interface RepairInfoService {
    void updateDateStart(LocalDate date, RepairInfo repairInfo);
    void updateStatus(RepairInfo repairInfo, RepairStatus repairStatus);
    RepairInfoDTO getRepairInfoById(long id);
    VehiculeDTO getVehiculeById(String name);
    RepairDTO getRepair(String name);
    void addReparation(String vehiculeName, String repairName, LocalDate date);

}
