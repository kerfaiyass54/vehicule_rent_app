package servicesImpl;


import DTO.RepairDTO;
import entities.*;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.RepairInfoRepository;
import repositories.RepairRepository;
import repositories.TicketRepository;
import services.RepairService;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class RepairServiceImpl implements RepairService {

    @Autowired
    private RepairRepository repairRepository;

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private RepairInfoRepository repairInfoRepository;



    @Override
    public void addRepair(Repair repair){
        repairRepository.save(repair);
    }
    @Override
    public void deleteRepair(Repair repair){
        repairRepository.delete(repair);
    }
    @Override
    public void updateRepair(Repair repair){}
    @Override
    public RepairDTO getRepair(String nameRepair){
        return repairRepository.getById(id);
    }
    @Override
    public void changeRepairPassword(Repair repair, String newPassword){
        repairRepository.findRepairByNameRepair(repair.getNameRepair()).setPass(newPassword);
    }
    @Override
    public List<Ticket> getTickets(String repairName){
        return repairRepository.findRepairByNameRepair(repairName).getTickets();
    }
    @Override
    public List<RepairInfo> getRepairInfo(String repairName){
        return repairRepository.findRepairByNameRepair(repairName).getRepairInfos();
    }
    @Override
    public List<Vehicule> getVehicules(String repairName){

    }
    @Override
    public void updateLocation(String repairName, String locationName){
        repairRepository.findRepairByNameRepair(repairName);
    }
    @Override
    public Location getLocation(String locationName){

    }
}
