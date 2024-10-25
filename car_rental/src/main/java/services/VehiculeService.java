package services;

import entities.Category;
import entities.Vehicule;
import enums.CategoryName;

public interface VehiculeService {

    void addVehicule(Vehicule vehicule, String nameSupplier, CategoryName nameCategory);
    void deleteVehicule(Vehicule vehicule);
    void updateVehicule(Vehicule vehicule);
    Vehicule getVehicule(long id);
    Category getCategory(long id);
    void buyVehicule(String vehiculeName, String nameClient, int period);
    boolean canHeBuyTheVehicule(Vehicule vehicule);
    void returnVehicule(String vehiculeName, String nameClient);



}
