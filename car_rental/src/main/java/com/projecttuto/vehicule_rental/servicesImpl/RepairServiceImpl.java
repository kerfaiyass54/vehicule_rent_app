package com.projecttuto.vehicule_rental.servicesImpl;


import com.projecttuto.vehicule_rental.DTO.LocationDTO;
import com.projecttuto.vehicule_rental.DTO.RepairDTO;
import com.projecttuto.vehicule_rental.entities.*;
import com.projecttuto.vehicule_rental.repositories.*;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.projecttuto.vehicule_rental.services.RepairService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private AdminRepository adminRepository;


    @Override
    public void addRepair(Repair repair, String location){
        Optional<Location> loc = locationRepository.findByName(location);
        repair.setLocation(loc.get());
        repairRepository.save(repair);
    }
    @Override
    public void deleteRepair(long id){
        repairRepository.delete(repairRepository.findById(id).get());
    }
    @Override
    public void updateRepair(RepairDTO repairDTO){
        Repair r = repairRepository.findByNameRepair(repairDTO.getNameRepair()).get();
        r.setNameRepair(repairDTO.getNameRepair());
        r.setPass(repairDTO.getPass());
        r.setEmail(repairDTO.getEmail());
        repairRepository.save(r);
    }

    @Override
    public RepairDTO getRepair(String nameRepair){
        RepairDTO repairDTO = new RepairDTO();
        Repair repair = repairRepository.findRepairByNameRepair(nameRepair);
        repairDTO.setNameRepair(nameRepair);
        repairDTO.setIdRepair(repair.getIdRepair());
        repairDTO.setEmail(repair.getEmail());
        repairDTO.setLocationRepair(repair.getLocation().getName());
        return repairDTO;
    }

    @Override
    public void changeRepairPassword(Repair repair, String newPassword){
        repairRepository.findByNameRepair(repair.getNameRepair()).get().setPass(newPassword);
    }
    @Override
    public List<Ticket> getTickets(String repairName){
        return repairRepository.findByNameRepair(repairName).get().getTickets();
    }
    @Override
    public List<RepairInfo> getRepairInfo(String repairName){
        return repairRepository.findByNameRepair(repairName).get().getRepairInfos();
    }
    @Override
    public List<Vehicule> getVehicules(String repairName){
        List<RepairInfo> repairInfo = getRepairInfo(repairName);
        List<Vehicule> vehicules = new ArrayList<>();
        for(RepairInfo r : repairInfo){
            vehicules.add(r.getVehicule());
        }
        return vehicules;
    }
    @Override
    public void updateLocation(String repairName, String locationName){
        repairRepository.findByNameRepair(repairName).get().setLocation(locationRepository.findByName(locationName).get());
    }
    @Override
    public LocationDTO getLocation(String locationName){
        LocationDTO locationDTO = new LocationDTO();
        Location location = locationRepository.findByName(locationName).get();
        locationDTO.setIdLoc(location.getIdLoc());
        locationDTO.setCountry(location.getCountry());
        locationDTO.setName(location.getName());
        return locationDTO;
    }


}
