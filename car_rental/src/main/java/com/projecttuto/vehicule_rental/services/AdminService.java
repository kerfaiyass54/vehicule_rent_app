package com.projecttuto.vehicule_rental.services;

import com.projecttuto.vehicule_rental.DTO.*;
import java.util.List;

public interface AdminService {

    List<ClientDTO> getClients(long adminId);
    List<SupplierDTO> getSuppliers(long adminId);
    List<RepairDTO> getRepairs(long adminId);
    List<LocationDTO> getLocations(long adminId);
    void updateDetails(AdminDTO adminDTO);
    AdminDTO getDetails(String adminName);
    List <String> getNames(long adminId);

}
