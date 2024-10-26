package repositories;

import entities.Category;
import entities.Client;
import entities.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    public Client findClientByNameClient(String name);
    public Client findClientByEmailClient(String email);
    public Client findClientsByLocation(Location location);
}
