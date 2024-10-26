package repositories;

import entities.Admin;
import entities.Adress;
import entities.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdressRepository extends JpaRepository<Adress, Long> {
    public Adress findAdressByRoad(String road);

    public List<Adress> findAdressesByLocation(Location location);
}
