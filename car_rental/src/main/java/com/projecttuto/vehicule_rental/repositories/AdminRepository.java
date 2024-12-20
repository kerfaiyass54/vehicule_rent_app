package com.projecttuto.vehicule_rental.repositories;

import com.projecttuto.vehicule_rental.entities.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
    public Admin findAdminByAdminName(String adminName);
}
