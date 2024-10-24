package repositories;

import entities.Admin;
import entities.Vehicule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehiculeRepository extends JpaRepository<Vehicule, Long> {

    public Vehicule findVehiculeByNameVehicule(String name);
    public Vehicule findVehiculeByIdVehicule(long id);
}
