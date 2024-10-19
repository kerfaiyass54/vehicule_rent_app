package services;

import entities.Buying;
import entities.Client;
import entities.Vehicule;

public interface BuyingService {
    Buying getBuyingById(int id);
    Vehicule getVehicule(String vehicule);
    Client getClient(String clientName);
    void deleteBuyingById(int id);

}
