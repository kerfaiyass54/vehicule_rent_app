package servicesImpl;


import entities.Category;
import entities.Vehicule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.*;
import services.VehiculeService;

@Service
public class VehiculeServiceImpl implements VehiculeService {

    @Autowired
    private VehiculeRepository vehiculeRepository;

    @Autowired
    private BuyingRepository buyingRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private RepairInfoRepository repairInfoRepository;

    @Autowired
    private SupplierRepository supplierRepository;

    @Override
    public void addVehicule(Vehicule vehicule){
        vehiculeRepository.save(vehicule);
    }
    @Override
    public void deleteVehicule(Vehicule vehicule){
        vehiculeRepository.delete(vehiculeRepository.findVehiculeByNameVehicule(vehicule.getNameVehicule()));
    }
    @Override
    public void updateVehicule(Vehicule vehicule){
        Vehicule v = vehiculeRepository.findVehiculeByNameVehicule(vehicule.getNameVehicule());
        v.setNameVehicule(vehicule.getNameVehicule());
        v.setBrand(vehicule.getBrand());
        v.setColor(vehicule.getColor());
        v.setPrice(vehicule.getPrice());
        v.setHighSpeed(vehicule.getHighSpeed());
        vehiculeRepository.save(v);
    }
    @Override
    public Vehicule getVehicule(long id){
        return vehiculeRepository.findVehiculeByIdVehicule(id);
    }
    @Override
    public Category getCategory(long id){
        return vehiculeRepository.findVehiculeByIdVehicule(id).getCategory();

    }
}
