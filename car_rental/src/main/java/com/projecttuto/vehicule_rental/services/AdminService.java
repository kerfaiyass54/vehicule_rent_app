package com.projecttuto.vehicule_rental.services;

import com.projecttuto.vehicule_rental.DTO.ClientDTO;
import com.projecttuto.vehicule_rental.DTO.LocationDTO;
import com.projecttuto.vehicule_rental.DTO.RepairDTO;
import com.projecttuto.vehicule_rental.DTO.SupplierDTO;
import com.projecttuto.vehicule_rental.entities.*;

import java.util.List;

public interface AdminService {

    List<ClientDTO> getClients();
    List<SupplierDTO> getSuppliers();
    List<RepairDTO> getRepairs();
    List<LocationDTO> getLocations();
    void updateDetails(Admin admin);
    Admin getDetails(String adminName);

}
