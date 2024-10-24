package servicesImpl;


import entities.Client;
import entities.Repair;
import entities.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.ClientRepository;
import repositories.DemandRepository;
import repositories.RepairRepository;
import repositories.TicketRepository;
import services.TicketService;

@Service
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
    public void changeStatus(long id){

    }

    @Override
    public void addTicket(Ticket ticket){
        ticketRepository.save(ticket);
    }

    @Override
    public void removeTicket(Ticket ticket){}
}
