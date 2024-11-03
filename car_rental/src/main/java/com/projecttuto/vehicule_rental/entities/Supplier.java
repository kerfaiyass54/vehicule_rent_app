package com.projecttuto.vehicule_rental.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Entity
@Data
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name="supplier")
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idsupp")
    private long idSupp;

    @Column(name="supp_name")
    private String suppName;

    @Column(name="nationality")
    private String nationality;

    @Column(name="email_supp")
    private String email;

    @Column(name="pass_supp")
    private String pass;

    @ManyToOne
    @JoinColumn(name = "id_admin_supp", referencedColumnName = "idadmin")
    private Admin admin;

    @Column(name="role_user", nullable = false)
    private String role;

    @OneToMany(mappedBy = "supplier")
    private List<Vehicule> vehicules;

    @OneToMany(mappedBy = "supplier")
    private List<Adress> adresses;

    @OneToMany(mappedBy = "supplier")
    private List<Subscription> subscriptions;

    @OneToMany(mappedBy = "supplier")
    private List<Demand> demands;

    @OneToMany(mappedBy = "supplier")
    private List<Category> categories;


}
