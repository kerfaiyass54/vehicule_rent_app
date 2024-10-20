package servicesImpl;


import entities.Client;
import entities.Subscription;
import entities.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.ClientRepository;
import repositories.SubscriptionRepository;
import repositories.SupplierRepository;
import services.SubscriptionService;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {

    @Autowired
    private SubscriptionRepository subscriptionRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private SupplierRepository supplierRepository;

    @Override
    public void addSubscription(Subscription subscription){}
    @Override
    public void removeSubscription(Subscription subscription){}
    @Override
    public void renewSubscription(Subscription subscription){}
    @Override
    public Client getClientByEmail(String email){
        return clientRepository.findClientByEmailClient(email);
    }
    @Override
    public Supplier getSupplier(String name){
        return supplierRepository.findSupplierBySuppName(name);
    }
}
