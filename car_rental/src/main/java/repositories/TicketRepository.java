package repositories;

import entities.Category;
import entities.Client;
import entities.Repair;
import entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
    public Ticket findTicketByClient(Client client);

    public Ticket findTicketByRepair(Repair repair);

    public List<Ticket> findTicketsByRepair(Repair repair);

}
