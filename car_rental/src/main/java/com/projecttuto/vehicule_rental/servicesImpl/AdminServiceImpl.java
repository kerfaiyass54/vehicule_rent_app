package com.projecttuto.vehicule_rental.servicesImpl;


import com.projecttuto.vehicule_rental.DTO.ClientDTO;
import com.projecttuto.vehicule_rental.entities.*;
import com.projecttuto.vehicule_rental.mappers.ClientDTOMapper;
import com.projecttuto.vehicule_rental.repositories.*;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.projecttuto.vehicule_rental.services.AdminService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private com.projecttuto.vehicule_rental.repositories.RepairRepository RepairRepository;

    @Autowired
    private SupplierRepository supplierRepository;

    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private ClientDTOMapper clientDTOMapper;

    @Override
    public List<ClientDTO> getClients(){
        List<Client> clients = clientRepository.findAll();
        return clients.stream()
                .map(clientDTOMapper::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<Repair> getRepairs(){
        return RepairRepository.findAll();
    }

    @Override
    public List<Supplier> getSuppliers(){
        return supplierRepository.findAll();
    }

    @Override
    public void updateDetails(Admin admin){
        Admin a = adminRepository.findAdminByAdminName(admin.getAdminName());
        a.setAdminName(admin.getAdminName());
        a.setEmail(admin.getEmail());
        a.setPass(admin.getPass());
        adminRepository.save(a);
    }

    @Override
    public Admin getDetails(String adminName){
        return adminRepository.findAdminByAdminName(adminName);
    }

    @Override
    public List<Location> getLocations(){
        return locationRepository.findAll();
    }


}
