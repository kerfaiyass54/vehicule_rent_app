package com.projecttuto.vehicule_rental.repositories;

import com.projecttuto.vehicule_rental.entities.Admin;
import org.hibernate.query.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;


@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
    public Admin findAdminByAdminName(String adminName);

    public Admin findAdminByIdAdmin(long idAdmin);

    public Admin findAdminByEmail(String email);

}
