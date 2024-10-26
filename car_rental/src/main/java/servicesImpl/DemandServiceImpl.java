package servicesImpl;


import entities.Demand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.DemandRepository;
import repositories.SupplierRepository;
import repositories.TicketRepository;
import services.DemandService;

@Service
public class DemandServiceImpl implements DemandService {

    @Autowired
    private DemandRepository demandRepository;

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private SupplierRepository supplierRepository;

    @Override
    public void addDemand(Demand demand, String supplierName , String ticketName){

    }




}
