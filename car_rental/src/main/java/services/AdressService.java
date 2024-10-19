package services;

import entities.Adress;
import entities.Location;
import entities.Supplier;

import java.util.List;

public interface AdressService {
    List<Adress> getAdresses();
    void addAdress(Adress adress);
    void deleteAdress(Adress adress);
    void updateAdress(Adress adress);
    Supplier getSupplier(String suppName);
    Location getLocation(String locationName);

}
