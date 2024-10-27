package services;

import DTO.DemandDTO;
import entities.Demand;
import entities.Ticket;
import enums.ConfirmStatus;

import java.util.List;

public interface DemandService {
    void addDemand(Demand demand, String supplierName , Ticket ticket);
    void removeDemand(Demand demand);
    List<Demand> getDemands(String name);
    DemandDTO getDemand(long id);
    void updateDemandStatus(Demand demand, ConfirmStatus status);
}
