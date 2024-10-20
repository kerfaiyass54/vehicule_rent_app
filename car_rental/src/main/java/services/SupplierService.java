package services;

import entities.Adress;
import entities.Subscription;
import entities.Supplier;
import entities.Vehicule;

import java.util.List;

public interface SupplierService {
    void addSupplier(Supplier supplier);
    void updateSupplier(Supplier supplier);
    void deleteSupplier(Supplier supplier);
    Supplier getSupplier(long id);
    void changeSupplierPassword(Supplier supplier, String newPassword);
    List<Subscription> getSubscriptions(Supplier supplier);
    List<Adress> getAdresses(Supplier supplier);
    List<Vehicule> getVehicules(Supplier supplier);


}
