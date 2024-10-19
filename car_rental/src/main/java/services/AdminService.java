package services;

import entities.Client;
import entities.Repair;
import entities.Supplier;

import java.util.List;

public interface AdminService {

    List<Client> getClients();
    List<Supplier> getSuppliers();
    List<Repair> getRepairs();

}
