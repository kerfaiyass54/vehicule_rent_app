package com.projecttuto.vehicule_rental.repositories;

import com.projecttuto.vehicule_rental.entities.Client;
import com.projecttuto.vehicule_rental.entities.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    public Client findClientByNameClient(String name);
    public Client findClientByEmail(String email);
    public Client findClientsByLocation(Location location);
}
