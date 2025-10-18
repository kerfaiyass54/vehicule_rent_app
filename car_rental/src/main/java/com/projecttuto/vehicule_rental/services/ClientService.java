package com.projecttuto.vehicule_rental.services;

import com.projecttuto.vehicule_rental.DTO.ClientDTO;
import com.projecttuto.vehicule_rental.entities.Client;
import org.springframework.data.domain.Page;


public interface ClientService {
    void addClient(Client client, String locationName);
    void deleteClient(long id);
    ClientDTO getClient(String clientName);
    void updateClient(ClientDTO clientDTO);
    void changePassword(String nameClient, String newPassword);
    void addToBudget(double budgetExtra, String nameClient);
    void changeLocation(String nameClient, String newLocation);
    Page<Client> listOfClients( int page, int size, String search);

}
