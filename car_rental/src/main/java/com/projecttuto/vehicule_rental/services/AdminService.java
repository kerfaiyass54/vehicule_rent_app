package com.projecttuto.vehicule_rental.services;

import com.projecttuto.vehicule_rental.DTO.*;
import com.projecttuto.vehicule_rental.entities.*;

import java.util.List;

public interface AdminService {

    List<ClientDTO> getClients();
    List<SupplierDTO> getSuppliers();
    List<RepairDTO> getRepairs();
    List<LocationDTO> getLocations();
    void updateDetails(AdminDTO adminDTO);
    AdminDTO getDetails(String adminName);
    List <String> getNames();

}
