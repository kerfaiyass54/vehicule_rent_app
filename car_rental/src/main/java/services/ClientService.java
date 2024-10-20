package services;

import entities.Client;

public interface ClientService {
    void addClient(Client client);
    void deleteClient(long id);
    Client getClient(long id);
    void updateClient(Client client);
    void changePassword(String oldPassword, String newPassword);
}
