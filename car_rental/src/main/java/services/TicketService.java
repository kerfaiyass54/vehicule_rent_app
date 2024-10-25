package services;

import entities.Client;
import entities.Repair;
import entities.Ticket;

public interface TicketService {

    Client getClient(String name);
    Repair getRepair(String name);
    void changeStatus(long id);
    void addTicket(Ticket ticket, String repairName, String clientName);
    void removeTicket(Ticket ticket);

}
