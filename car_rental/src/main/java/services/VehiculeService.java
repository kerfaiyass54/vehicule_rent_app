package services;

import entities.Category;
import entities.Vehicule;

public interface VehiculeService {

    void addVehicule(Vehicule vehicule);
    void deleteVehicule(Vehicule vehicule);
    void updateVehicule(Vehicule vehicule);
    Vehicule getVehicule(long id);
    Category getCategory(long id);

}
