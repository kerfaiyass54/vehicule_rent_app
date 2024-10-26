package services;

import entities.Buying;
import entities.Client;
import entities.Vehicule;

public interface BuyingService {
    Buying getBuyingById(long id);
    Vehicule getVehicule(String vehicule);
    Client getClient(String clientName);
    void deleteBuyingById(long id);
    void buyVehicule(String vehiculeName, String clientName, int period);
    void returnVehicule(String vehiculeName, String clientName);
}
