package servicesImpl;


import DTO.SupplierDTO;
import entities.*;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.*;
import services.SupplierService;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
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
    public void addSupplier(Supplier supplier){
        supplierRepository.save(supplier);
    }

    @Override
    public void updateSupplier(Supplier supplier){
        Supplier supplier1 = supplierRepository.getById(supplier.getIdSupp());
        supplier1.setNationality(supplier.getNationality());
        supplier1.setPass(supplier.getPass());
        supplier1.setSuppName(supplier.getSuppName());
        supplier1.setEmail(supplier.getEmail());
        supplierRepository.save(supplier1);
    }

    @Override
    public void deleteSupplier(Supplier supplier){
        supplierRepository.delete(supplier);
    }

    @Override
    public SupplierDTO getSupplier(String supplierName){
        SupplierDTO supplierDTO = new SupplierDTO();
        Supplier supplier = supplierRepository.findSupplierBySuppName(supplierName);
        supplierDTO.setIdSupp(supplier.getIdSupp());
        supplierDTO.setNationality(supplier.getNationality());
        supplierDTO.setSuppName(supplier.getSuppName());
        return supplierDTO;
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
