package servicesImpl;


import DTO.RepairDTO;
import DTO.RepairInfoDTO;
import DTO.VehiculeDTO;
import entities.Repair;
import entities.RepairInfo;
import entities.Vehicule;
import enums.RepairStatus;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.RepairInfoRepository;
import repositories.RepairRepository;
import repositories.VehiculeRepository;
import services.RepairInfoService;

import java.time.LocalDate;

@Service
@AllArgsConstructor
@Slf4j
public class RepairInfoServiceImpl implements RepairInfoService {

    @Autowired
    private RepairInfoRepository repairInfoRepository;

    @Autowired
    private VehiculeRepository vehiculeRepository;

    @Autowired
    private RepairRepository repairRepository;

    @Override
    public void updateDateStart(LocalDate date, RepairInfo repairInfo){
        RepairInfo repairInfo1 = repairInfoRepository.getById(repairInfo.getIdInfo());
        repairInfo1.setDateStart(date);
        repairInfoRepository.save(repairInfo1);
    }

    @Override
    public void updateStatus(RepairInfo repairInfo, RepairStatus repairStatus){
        RepairInfo repairInfo1 = repairInfoRepository.getById(repairInfo.getIdInfo());
        repairInfo1.setRepairStatus(repairStatus);
        repairInfoRepository.save(repairInfo1);
    }

    @Override
    public RepairInfoDTO getRepairInfoById(long id){
        RepairInfo repairInfo = repairInfoRepository.getById(id);
        RepairInfoDTO repairInfoDTO = new RepairInfoDTO();
        repairInfoDTO.setIdInfo(repairInfo.getIdInfo());
        repairInfoDTO.setDateStart(repairInfo.getDateStart());
        repairInfoDTO.setDateStart(repairInfo.getDateStart());
        return repairInfoDTO;
    }

    @Override
    public VehiculeDTO getVehiculeById(String name){
        VehiculeDTO vehiculeDTO = new VehiculeDTO();
        Vehicule vehicule = vehiculeRepository.findVehiculeByNameVehicule(name);
        vehiculeDTO.setIdVehicule(vehicule.getIdVehicule());
        vehiculeDTO.setNameVehicule(vehicule.getNameVehicule());
        vehiculeDTO.setVehiculeStatus(vehicule.getVehiculeStatus());
        vehiculeDTO.setBrand(vehicule.getBrand());
        vehiculeDTO.setColor(vehicule.getColor());
        vehiculeDTO.setHighSpeed(vehicule.getHighSpeed());
        vehiculeDTO.setTransmission(vehicule.getTransmission());
        vehiculeDTO.setPrice(vehicule.getPrice());
        return vehiculeDTO;
    }

    @Override
    public RepairDTO getRepair(String name){
        RepairDTO repairDTO = new RepairDTO();
        Repair repair = repairRepository.findRepairByNameRepair(name);
        repairDTO.setIdRepair(repair.getIdRepair());
        repairDTO.setNameRepair(repair.getNameRepair());
        return repairDTO;
    }

    @Override
    public void addReparation(String vehiculeName, String repairName, LocalDate date){
        RepairInfo repairInfo = new RepairInfo();
        Vehicule vehicule = vehiculeRepository.findVehiculeByNameVehicule(vehiculeName);
        Repair repair = repairRepository.findRepairByNameRepair(repairName);
        repairInfo.setDateStart(date);
        repairInfo.setVehicule(vehicule);
        repairInfo.setRepair(repair);
        if(LocalDate.now().equals(repairInfo.getDateStart())){
            repairInfo.setRepairStatus(RepairStatus.PENDING_FINISH);
        }
        else{
            repairInfo.setRepairStatus(RepairStatus.PENDING_START);
        }
        repairInfoRepository.save(repairInfo);
    }

}
