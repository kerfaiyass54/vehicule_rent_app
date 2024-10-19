package services;

import entities.Supplier;

public interface SupplierService {
    void addSupplier(Supplier supplier);
    void updateSupplier(Supplier supplier);
    void deleteSupplier(Supplier supplier);
    Supplier getSupplier(int id);
    void changeSupplierPassword(Supplier supplier, String newPassword);
}
