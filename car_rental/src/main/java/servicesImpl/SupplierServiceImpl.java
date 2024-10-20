package servicesImpl;


import entities.Adress;
import entities.Subscription;
import entities.Supplier;
import entities.Vehicule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.*;
import services.SupplierService;

import java.util.List;

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


    @Override
    public void addSupplier(Supplier supplier){}
    @Override
    public void updateSupplier(Supplier supplier){}
    @Override
    public void deleteSupplier(Supplier supplier){}
    @Override
    public Supplier getSupplier(long id){
        return supplierRepository.getById(id);
    }
    @Override
    public void changeSupplierPassword(Supplier supplier, String newPassword){

    }
    @Override
    public List<Subscription> getSubscriptions(Supplier supplier){
        return supplierRepository.getById(supplier.getIdSupp()).getSubscriptions();
    }
    @Override
    public List<Adress> getAdresses(Supplier supplier){
        return supplierRepository.getById(supplier.getIdSupp()).getAdresses();
    }
    @Override
    public List<Vehicule> getVehicules(Supplier supplier){
        return supplierRepository.getById(supplier.getIdSupp()).getVehicules();
    }

}
