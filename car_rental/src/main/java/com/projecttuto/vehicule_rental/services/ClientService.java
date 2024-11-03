package com.projecttuto.vehicule_rental.services;

import com.projecttuto.vehicule_rental.DTO.ClientDTO;
import com.projecttuto.vehicule_rental.entities.Client;

public interface ClientService {
    void addClient(Client client, String locationName);
    void deleteClient(long id);
    ClientDTO getClient(String clientName);
    void updateClient(ClientDTO clientDTO);
    void changePassword(String nameClient, String newPassword);
    boolean isClientExist(String name);
    void addToBudget(double budgetExtra, String nameClient);
    void changeLocation(String nameClient, String newLocation);
    boolean isCinExists(String cin);

}
