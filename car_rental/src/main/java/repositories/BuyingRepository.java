package repositories;

import entities.Buying;
import entities.Client;
import entities.Vehicule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BuyingRepository extends JpaRepository<Buying, Long> {

    public Buying findBuyingByVehicule(Vehicule vehicule);

    public List<Buying> findBuyingsByClient(Client client);


}
