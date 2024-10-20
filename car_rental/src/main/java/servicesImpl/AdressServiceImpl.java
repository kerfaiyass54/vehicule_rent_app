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
    public void addAdress(Adress adress){
        adressRepository.save(adress);
    }

    @Override
    public void deleteAdress(Adress adress){
        adressRepository.delete(adress);
    }

    @Override
    public void updateAdress(Adress adress){
        Adress adr = adressRepository.getById(adress.getIdAdress());
        adr.setRoad(adress.getRoad());
        adr.setLocation(adress.getLocation());
        adr.setNumber(adress.getNumber());
        adr.setSupplier(adress.getSupplier());
        adressRepository.save(adr);
    }

    @Override
    public Supplier getSupplier(String suppName){
        return supplierRepository.findByName(suppName);
    }

    @Override
    public Location getLocation(String locationName){
        return locationRepository.findByName(locationName);
    }
}
