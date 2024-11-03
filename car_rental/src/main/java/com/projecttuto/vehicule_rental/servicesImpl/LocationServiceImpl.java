package com.projecttuto.vehicule_rental.servicesImpl;


import com.projecttuto.vehicule_rental.DTO.LocationDTO;
import com.projecttuto.vehicule_rental.entities.*;
import com.projecttuto.vehicule_rental.repositories.*;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.projecttuto.vehicule_rental.services.LocationService;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class LocationServiceImpl implements LocationService {

    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private RepairRepository repairRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private AdressRepository adressRepository;

    @Autowired
    private AdminRepository adminRepository;

    @Override
    public List<Repair> getRepairs(String locationName){
        Location location = locationRepository.findLocationByName(locationName);
        return location.getRepairs();
    }

    @Override
    public List<Supplier> getSuppliers(String locationName){
        Location location = locationRepository.findLocationByName(locationName);
        List<Adress> adresses = location.getAdresses();
        List<Supplier> suppliers = new ArrayList<>();
        for(Adress adress : adresses){
            suppliers.add(adress.getSupplier());
        }
        return suppliers;
    }

    @Override
    public List<Client> getClients(String locationName){

        Location location = locationRepository.findLocationByName(locationName);
        return location.getClients();

    }

    @Override
    public void addLocation(Location location, String adminName){
        Admin admin = adminRepository.findAdminByAdminName(adminName);
        location.setAdmin(admin);
        locationRepository.save(location);
    }

    @Override
    public void deleteLocation(String locationName){
        Location location = locationRepository.findLocationByName(locationName);
        if(location.getClients().isEmpty() && location.getRepairs().isEmpty() && location.getAdresses().isEmpty()){
            locationRepository.delete(location);
        }
    }

    @Override
    public LocationDTO getLocation(String locationName){
        Location location = locationRepository.findLocationByName(locationName);
        LocationDTO locationDTO = new LocationDTO();
        locationDTO.setCountry(location.getCountry());
        locationDTO.setName(location.getName());
        locationDTO.setIdLoc(location.getIdLoc());
        return locationDTO;
    }



    @Override
    public List<String> getLocationNamesByCountry(String country){
        List<Location> locations = locationRepository.findLocationsByCountry(country);
        List<String> locationNames = new ArrayList<>();
        for(Location location : locations){
            locationNames.add(location.getName());
        }
        return locationNames;
    }

    @Override
    public List<String> getLocationsNames(){
        List<String> locationNames = new ArrayList<>();
        List<Location> locations = locationRepository.findAll();
        for(Location location : locations){
            locationNames.add(location.getName());
        }
        return locationNames;
    }


}
