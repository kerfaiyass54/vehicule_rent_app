package servicesImpl;


import DTO.SubscriptionDTO;
import entities.Client;
import entities.Subscription;
import entities.Supplier;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.ClientRepository;
import repositories.SubscriptionRepository;
import repositories.SupplierRepository;
import services.SubscriptionService;

@Service
@AllArgsConstructor
@Slf4j
public class SubscriptionServiceImpl implements SubscriptionService {

    @Autowired
    private SubscriptionRepository subscriptionRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private SupplierRepository supplierRepository;

    @Override
    public void addSubscription(Subscription subscription, String emailClient, String nameSupplier){
        Client client = clientRepository.findClientByEmailClient(emailClient);
        subscription.setClient(client);
        subscription.setSupplier(supplierRepository.findSupplierBySuppName(nameSupplier));
        client.setBudget(client.getBudget() - subscription.getPrice());
        clientRepository.save(client);
        subscriptionRepository.save(subscription);
    }
    @Override
    public void removeSubscription(Subscription subscription){
        subscriptionRepository.delete(subscription);
    }
    @Override
    public void renewSubscription(Subscription subscription, String nameClient, int time){

    }
    @Override
    public Client getClientByEmail(String email){
        return clientRepository.findClientByEmailClient(email);
    }
    @Override
    public Supplier getSupplier(String name){
        return supplierRepository.findSupplierBySuppName(name);
    }

    @Override
    public boolean isClientSubscript(String emailClient, String nameSupplier){
        return subscriptionRepository.findSubscriptionByClientAndSupplier(clientRepository.findClientByEmailClient(emailClient), supplierRepository.findSupplierBySuppName(nameSupplier)) != null;
    }

    @Override
    public SubscriptionDTO getSubscription(String emailClient, String nameSupplier){
        SubscriptionDTO subscriptionDTO = new SubscriptionDTO();
        Subscription subscription = subscriptionRepository.findSubscriptionByClientAndSupplier(clientRepository.findClientByEmailClient(emailClient),supplierRepository.findSupplierBySuppName(nameSupplier));
        subscriptionDTO.setDateEnd(subscription.getDateEnd());
        subscriptionDTO.setDateStart(subscription.getDateStart());
        subscriptionDTO.setType(subscription.getType());
        subscriptionDTO.setPrice(subscription.getPrice());
        subscriptionDTO.setDateEnd(subscription.getDateEnd());
        subscriptionDTO.setReduce(subscription.getReduce());
        return subscriptionDTO;
    }

}
