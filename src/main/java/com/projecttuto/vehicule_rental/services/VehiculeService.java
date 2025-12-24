package com.projecttuto.vehicule_rental.services;

import com.projecttuto.vehicule_rental.entities.Category;
import com.projecttuto.vehicule_rental.entities.Vehicule;
import com.projecttuto.vehicule_rental.enums.CategoryName;

public interface VehiculeService {

    void addVehicule(Vehicule vehicule, String nameSupplier, CategoryName nameCategory);
    void deleteVehicule(Vehicule vehicule);
    void updateVehicule(Vehicule vehicule);
    Vehicule getVehicule(long id);
    Category getCategory(long id);




}
