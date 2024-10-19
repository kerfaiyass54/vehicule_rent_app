package services;

import entities.Client;
import entities.Repair;
import entities.Supplier;

import java.util.List;

public interface LocationService {
    List<Repair> getRepairs();
    List<Supplier> getSuppliers();
    List<Client> getClients();

}
