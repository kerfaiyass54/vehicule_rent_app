package servicesImpl;


import entities.Buying;
import entities.Client;
import entities.Vehicule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.BuyingRepository;
import repositories.ClientRepository;
import repositories.VehiculeRepository;
import services.BuyingService;

@Service
public class BuyingServiceImpl implements BuyingService {

    @Autowired
    private BuyingRepository buyingRepository;

    @Autowired
    private VehiculeRepository vehiculeRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public Buying getBuyingById(long id){
        return buyingRepository.getById(id);
    }

    @Override
    public Vehicule getVehicule(String vehicule){
        return vehiculeRepository.findVehiculeByNameVehicule(vehicule);
    }

    @Override
    public Client getClient(String clientName){
        return clientRepository.findClientByNameClient( clientName );
    }

    @Override
    public void deleteBuyingById(long id){
        buyingRepository.deleteById(id);
    }

}
