package com.projecttuto.vehicule_rental.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name="admin")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idadmin")
    private long idAdmin;

    @Column(name="admin_name", nullable = false)
    private String adminName;

    @Column(name="email_admin", nullable = false)
    private String email;

    @Column(name="pass_admin", nullable = false)
    private String pass;

    @Column(name="role_user", nullable = false)
    private String role;

    @OneToMany(mappedBy = "admin", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Client> clients;

    @OneToMany(mappedBy = "admin", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Repair> repairs;

    @OneToMany(mappedBy = "admin", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Supplier> suppliers;

    @OneToMany(mappedBy = "admin", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Location> locations;

}
