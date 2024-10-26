package services;

import entities.*;

import java.util.List;

public interface AdminService {

    List<Client> getClients();
    List<Supplier> getSuppliers();
    List<Repair> getRepairs();
    List<Location> getLocations();
    void updateDetails(Admin admin);

}
