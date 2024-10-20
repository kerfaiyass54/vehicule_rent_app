package services;

import entities.Demand;

import java.util.List;

public interface DemandService {
    void addDemand(Demand demand);
    void removeDemand(Demand demand);
    void updateDemand(Demand demand);
    List<Demand> getDemands();
    Demand getDemand(long id);
    void updtaeDemandStatus(Demand demand);
}
