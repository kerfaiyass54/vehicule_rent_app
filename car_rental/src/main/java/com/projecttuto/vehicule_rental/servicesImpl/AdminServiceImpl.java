package com.projecttuto.vehicule_rental.servicesImpl;


import com.projecttuto.vehicule_rental.DTO.*;
import com.projecttuto.vehicule_rental.entities.*;
import com.projecttuto.vehicule_rental.mappers.ClientDTOMapper;
import com.projecttuto.vehicule_rental.mappers.LocationDTOMapper;
import com.projecttuto.vehicule_rental.mappers.RepairDTOMapper;
import com.projecttuto.vehicule_rental.mappers.SupplierDTOMapper;
import com.projecttuto.vehicule_rental.repositories.*;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import com.projecttuto.vehicule_rental.services.AdminService;

import java.awt.print.Pageable;
import java.util.ArrayList;
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

    @Autowired
    private RepairDTOMapper repairDTOMapper;

    @Autowired
    private LocationDTOMapper locationDTOMapper;

    @Autowired
    private SupplierDTOMapper supplierDTOMapper;

    @Override
    public List<ClientDTO> getClients(){
        List<Client> clients = clientRepository.findAll();
        return clients.stream()
                .map(clientDTOMapper::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<RepairDTO> getRepairs(){
        return RepairRepository.findAll().stream()
                .map(repairDTOMapper::mapToDTORepair)
                .collect(Collectors.toList());
    }

    @Override
    public List<SupplierDTO> getSuppliers(){
        return supplierRepository.findAll().stream()
                .map(supplierDTOMapper::supplierDTOMapper)
                .collect(Collectors.toList());

    }

    @Override
    public void updateDetails(AdminDTO admin){
        Admin a = adminRepository.findAdminByAdminName(admin.getAdminName());
        a.setAdminName(admin.getAdminName());
        a.setEmail(admin.getEmail());
        a.setPass(admin.getPassword());
        adminRepository.save(a);
    }

    @Override
    public AdminDTO getDetails(String adminName){
        Admin admin = adminRepository.findAdminByAdminName(adminName);
        AdminDTO adminDTO = new AdminDTO();
        adminDTO.setAdminName(admin.getAdminName());
        adminDTO.setEmail(admin.getEmail());
        adminDTO.setPassword(admin.getPass());
        return adminDTO;
    }

    @Override
    public List<LocationDTO> getLocations(){
        return locationRepository.findAll().stream()
                .map(locationDTOMapper::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List <String> getNames(){
        List<String> names = new ArrayList<>();
        names.addAll(supplierRepository.findAll().stream().map(Supplier::getSuppName).toList());
        names.addAll(clientRepository.findAll().stream().map(Client::getNameClient).toList());
        names.addAll(RepairRepository.findAll().stream().map(Repair::getNameRepair).toList());
        return names;

    }
/*
    @Override
    public Page<ClientDTO> getPaginatedClients(Pageable pageable){
        return clientRepository.findAll(pageable).stream().map();
    }
*/

}
