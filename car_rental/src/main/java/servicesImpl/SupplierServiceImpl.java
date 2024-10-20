package servicesImpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.*;
import services.SupplierService;

@Service
public class SupplierServiceImpl implements SupplierService {
    @Autowired
    private SupplierRepository supplierRepository;

    @Autowired
    private SubscriptionRepository subscriptionRepository;

    @Autowired
    private VehiculeRepository vehiculeRepository;

    @Autowired
    private AdressRepository adressRepository;

    @Autowired
    private DemandRepository demandRepository;

}
