package com.projecttuto.vehicule_rental.repositories;

import com.projecttuto.vehicule_rental.entities.Adress;
import com.projecttuto.vehicule_rental.entities.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdressRepository extends JpaRepository<Adress, Long> {
    public Adress findAdressByRoad(String road);

    public List<Adress> findAdressesByLocation(Location location);
}
