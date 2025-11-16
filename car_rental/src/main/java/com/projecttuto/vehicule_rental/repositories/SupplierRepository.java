package com.projecttuto.vehicule_rental.repositories;

import com.projecttuto.vehicule_rental.entities.Adress;
import com.projecttuto.vehicule_rental.entities.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {
    public Supplier findSupplierBySuppName(String name);
    public Optional<Supplier> findBySuppName(String name);
    public Supplier findSupplierByEmail(String email);


}
