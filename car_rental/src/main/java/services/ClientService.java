package services;

import DTO.ClientDTO;
import entities.Client;

public interface ClientService {
    void addClient(Client client, String locationName);
    void deleteClient(long id);
    ClientDTO getClient(long id);
    void updateClient(ClientDTO clientDTO);
    void changePassword(String nameClient, String newPassword);
    boolean isClientExist(String name);
    void addToBudget(double budgetExtra, String nameClient);
    void changeLocation(String nameClient, String newLocation);
    boolean isCinExists(String cin);

}
