package com.projecttuto.vehicule_rental.services;

import com.projecttuto.vehicule_rental.entities.Adress;
import com.projecttuto.vehicule_rental.entities.Location;
import com.projecttuto.vehicule_rental.entities.Supplier;

import java.util.List;

public interface AdressService {
    List<Adress> getAdresses();
    void addAdress(Adress adress);
    void deleteAdress(String adressName);
    void updateAdress(String adressName);
    Supplier getSupplier(String suppName);
    Location getLocation(String locationName);
    void freeAdress(String adressName);

}
