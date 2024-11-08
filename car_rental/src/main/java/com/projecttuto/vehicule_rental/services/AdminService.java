package com.projecttuto.vehicule_rental.services;

import com.projecttuto.vehicule_rental.DTO.ClientDTO;
import com.projecttuto.vehicule_rental.entities.*;

import java.util.List;

public interface AdminService {

    List<ClientDTO> getClients();
    List<Supplier> getSuppliers();
    List<Repair> getRepairs();
    List<Location> getLocations();
    void updateDetails(Admin admin);
    Admin getDetails(String adminName);

}
