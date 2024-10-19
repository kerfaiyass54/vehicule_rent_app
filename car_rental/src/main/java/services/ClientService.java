package services;

import entities.Client;

public interface ClientService {
    void addClient(Client client);
    void deleteClient(int id);
    Client getClient(int id);
    void updateClient(Client client);
    void changePassword(String oldPassword, String newPassword);
}
