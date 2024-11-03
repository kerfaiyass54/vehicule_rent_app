package com.projecttuto.vehicule_rental.servicesImpl;

import com.projecttuto.vehicule_rental.entities.Adress;
import com.projecttuto.vehicule_rental.entities.Location;
import com.projecttuto.vehicule_rental.entities.Supplier;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.projecttuto.vehicule_rental.repositories.AdressRepository;
import com.projecttuto.vehicule_rental.repositories.LocationRepository;
import com.projecttuto.vehicule_rental.repositories.SupplierRepository;
import com.projecttuto.vehicule_rental.services.AdressService;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
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
