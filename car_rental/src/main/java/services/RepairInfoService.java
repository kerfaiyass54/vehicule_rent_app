package services;

import entities.Repair;
import entities.RepairInfo;
import entities.Vehicule;
import enums.RepairStatus;

import java.util.Date;

public interface RepairInfoService {
    void updateDateStart(Date date, RepairInfo repairInfo);
    void updateStatus(RepairInfo repairInfo, RepairStatus repairStatus);
    RepairInfo getRepairInfoById(int id);
    Vehicule getVehiculeById(int id);
    Repair getRepair(int id);

}
