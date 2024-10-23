package services;

import entities.Repair;
import entities.RepairInfo;
import entities.Vehicule;
import enums.RepairStatus;

import java.time.LocalDate;
import java.util.Date;

public interface RepairInfoService {
    void updateDateStart(LocalDate date, RepairInfo repairInfo);
    void updateStatus(RepairInfo repairInfo, RepairStatus repairStatus);
    RepairInfo getRepairInfoById(long id);
    Vehicule getVehiculeById(long id);
    Repair getRepair(long id);

}
