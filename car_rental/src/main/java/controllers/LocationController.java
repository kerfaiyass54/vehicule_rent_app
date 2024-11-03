package controllers;
import DTO.LocationDTO;
import entities.Client;
import entities.Location;
import entities.Repair;
import entities.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import services.LocationService;

import java.util.List;

@RestController
@RequestMapping("/location")
@CrossOrigin(origins = "http://localhost:4200")
public class LocationController {

    @Autowired
    private LocationService locationService;


    @GetMapping("/repairs/{locationName}")
    List<Repair> getRepairs(@PathVariable String locationName){
        return locationService.getRepairs(locationName);
    }

    @GetMapping("/suppliers/{locationName}")
    List<Supplier> getSuppliers(@PathVariable String locationName){
        return locationService.getSuppliers(locationName);
    }

    @GetMapping("/clients/{locationName}")
    List<Client> getClients(@PathVariable String locationName){
        return locationService.getClients(locationName);
    }

    @PostMapping("/add")
    void addLocation(@RequestBody Location location,@RequestParam String adminName){
        locationService.addLocation(location,adminName);
    }

    @PostMapping("/delete/{locationName}")
    void deleteLocation(@PathVariable String locationName){
        locationService.deleteLocation(locationName);
    }

    @GetMapping("/{locationName}/get")
    LocationDTO getLocation(@PathVariable String locationName){
        return locationService.getLocation(locationName);
    }

    @GetMapping("/names/{country}")
    List<String> getLocationNamesByCountry(@PathVariable String country){
        return locationService.getLocationNamesByCountry(country);
    }

    @GetMapping("/locNames")
    List<String> getLocationsNames(){
        return locationService.getLocationsNames();
    }

    
}
