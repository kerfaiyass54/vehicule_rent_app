package services;

import entities.*;

import java.util.List;

public interface RepairService {
    void addRepair(Repair repair);
    void deleteRepair(Repair repair);
    void updateRepair(Repair repair);
    Repair getRepair(long id);
    void changeRepairPassword(Repair repair, String newPassword);
    List<Ticket> getTickets(String repairName);
    List<RepairInfo> getRepairInfo(String repairName);
    List<Vehicule> getVehicules(String repairName);
    void updateLocation(String repairName, String locationName);
    Location getLocation(String locationName);
}
