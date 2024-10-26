package servicesImpl;

import entities.Adress;
import entities.Location;
import entities.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.AdressRepository;
import repositories.LocationRepository;
import repositories.SupplierRepository;
import services.AdressService;

import java.util.List;

@Service
public class AdressServiceImpl implements AdressService {

    @Autowired
    private AdressRepository adressRepository;

    @Autowired
    private SupplierRepository supplierRepository;

    @Autowired
    private LocationRepository locationRepository;

    @Override
    public List<Adress> getAdresses(){
        return adressRepository.findAll();
    }

    @Override
    public void freeAdress(String adressName){
        Adress adress = adressRepository.findAdressByRoad(adressName);
        adress.setSupplier(null);
        adressRepository.save(adress);
    }

    @Override
    public void addAdress(Adress adress){
        adressRepository.save(adress);
    }

    @Override
    public void deleteAdress(String adressName){
        Adress adress = adressRepository.findAdressByRoad(adressName);
        adressRepository.delete(adress);
    }

    @Override
    public void updateAdress(String adressName){
        Adress adress = adressRepository.findAdressByRoad(adressName);
        adress.setRoad(adress.getRoad());
        adress.setLocation(adress.getLocation());
        adress.setNumber(adress.getNumber());
        adress.setSupplier(adress.getSupplier());
        adressRepository.save(adress);
    }

    @Override
    public Supplier getSupplier(String suppName){
        return supplierRepository.findSupplierBySuppName(suppName);
    }

    @Override
    public Location getLocation(String locationName){
        return locationRepository.findLocationByName(locationName);
    }
}
