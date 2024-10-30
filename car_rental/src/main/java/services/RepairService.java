package services;

import DTO.LocationDTO;
import DTO.RepairDTO;
import entities.*;

import java.util.List;

public interface RepairService {
    void addRepair(Repair repair);
    void deleteRepair(Repair repair);
    void updateRepair(Repair repair);
    RepairDTO getRepair(String nameRepair);
    void changeRepairPassword(Repair repair, String newPassword);
    List<Ticket> getTickets(String repairName);
    List<RepairInfo> getRepairInfo(String repairName);
    List<Vehicule> getVehicules(String repairName);
    void updateLocation(String repairName, String locationName);
    LocationDTO getLocation(String locationName);
}
