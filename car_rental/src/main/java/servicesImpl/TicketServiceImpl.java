package servicesImpl;


import entities.Client;
import entities.Repair;
import entities.Ticket;
import enums.StatusRepair;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.ClientRepository;
import repositories.DemandRepository;
import repositories.RepairRepository;
import repositories.TicketRepository;
import services.TicketService;

@Service
@AllArgsConstructor
@Slf4j
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private RepairRepository repairRepository;

    @Autowired
    private DemandRepository demandRepository;

    @Override
    public Client getClient(String name){
        return clientRepository.findClientByNameClient(name );
    }
    @Override
    public Repair getRepair(String name){
        return repairRepository.findRepairByNameRepair(name );
    }

    @Override
    public void changeStatus(long id, StatusRepair status){
        Ticket ticket = ticketRepository.getById(id);
        ticket.setStatus(status);
        ticketRepository.save(ticket);
    }

    @Override
    public void addTicket(Ticket ticket, String repairName, String clientName){
        Client client = clientRepository.findClientByNameClient(clientName);
        Repair repair = repairRepository.findRepairByNameRepair(repairName);
        if(client != null && repair != null){
            ticket.setClient(client);
            ticket.setRepair(repair);
            ticketRepository.save(ticket);
        }
    }

    @Override
    public void removeTicket(Ticket ticket){}
}
