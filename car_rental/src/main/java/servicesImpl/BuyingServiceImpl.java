package servicesImpl;


import entities.Buying;
import entities.Client;
import entities.Vehicule;
import enums.BuyStatus;
import enums.VehiculeStatus;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.BuyingRepository;
import repositories.ClientRepository;
import repositories.VehiculeRepository;
import services.BuyingService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
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


    @Override
    public void returnVehicule(String vehiculeName, String clientName){
        Vehicule vehicule = vehiculeRepository.findVehiculeByNameVehicule(vehiculeName);
        Client client = clientRepository.findClientByNameClient(clientName);
        List<Buying> buyings = buyingRepository.findAll();
        for(Buying buying : buyings){
            if(buying.getClient().equals(client) && buying.getVehicule().equals(vehicule) && vehicule.getVehiculeStatus().equals(VehiculeStatus.TAKEN)){
                buying.setBuyStatus(BuyStatus.FINISHED);
                vehicule.setVehiculeStatus(VehiculeStatus.AVAILABLE);
                vehiculeRepository.save(vehicule);
                buyingRepository.save(buying);
                break;
            }
        }
    }

    @Override
    public void buyVehicule(String vehiculeName, String clientName, int period){
        Vehicule vehicule = vehiculeRepository.findVehiculeByNameVehicule(vehiculeName);
        Client client = clientRepository.findClientByNameClient(clientName);
        double payment = vehicule.getPrice() * period;
        if(vehicule.getVehiculeStatus() == VehiculeStatus.AVAILABLE && payment < client.getBudget()){
            Buying buying = new Buying();
            client.setBudget(client.getBudget() - payment);
            vehicule.setVehiculeStatus(VehiculeStatus.TAKEN);
            buying.setClient(client);
            buying.setVehicule(vehicule);
            buying.setPeriodBuy(period);
            buying.setDateBuy(LocalDate.now());
            buying.setBuyStatus(BuyStatus.BEING_USED);
            buyingRepository.save(buying);
            clientRepository.save(client);
            vehiculeRepository.save(vehicule);
        }
    }

}
