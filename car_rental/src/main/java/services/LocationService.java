package services;

import DTO.LocationDTO;
import entities.Client;
import entities.Location;
import entities.Repair;
import entities.Supplier;

import java.util.List;

public interface LocationService {
    List<Repair> getRepairs(String locationName);
    List<Supplier> getSuppliers(String locationName);
    List<Client> getClients(String locationName);
    void addLocation(Location location, String adminName);
    void deleteLocation(String locationName);
    LocationDTO getLocation(String locationName);
    List<String> getLocationNamesByCountry(String country);
    List<String> getLocationsNames();

}
