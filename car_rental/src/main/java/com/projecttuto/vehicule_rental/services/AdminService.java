package com.projecttuto.vehicule_rental.services;

import com.projecttuto.vehicule_rental.DTO.*;
import com.projecttuto.vehicule_rental.entities.*;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;
import java.util.List;

public interface AdminService {

    List<ClientDTO> getClients();
    public Page<ClientDTO> getPaginatedClients(Pageable pageable);
    List<SupplierDTO> getSuppliers();
    public Page<SupplierDTO> getPaginatedSuppliers(Pageable pageable);
    List<RepairDTO> getRepairs();
    public Page<RepairDTO> getPaginatedRepairs(Pageable pageable);
    List<LocationDTO> getLocations();
    public Page<LocationDTO> getPaginatedLocations(Pageable pageable);
    void updateDetails(AdminDTO adminDTO);
    AdminDTO getDetails(String adminName);
    List <String> getNames();

}
