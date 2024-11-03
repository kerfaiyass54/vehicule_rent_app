package com.projecttuto.vehicule_rental.repositories;

import com.projecttuto.vehicule_rental.entities.Location;
import com.projecttuto.vehicule_rental.entities.Repair;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepairRepository extends JpaRepository<Repair, Long> {
    public Repair findRepairByNameRepair(String name);
    public List<Repair> findRepairsByLocation(Location location);


}
