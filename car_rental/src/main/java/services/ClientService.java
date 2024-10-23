package services;

import DTO.ClientDTO;
import entities.Client;

public interface ClientService {
    void addClient(Client client);
    void deleteClient(long id);
    ClientDTO getClient(long id);
    void updateClient(ClientDTO clientDTO);
    void changePassword(String nameClient, String newPassword);
    boolean isClientExist(String name);
}
