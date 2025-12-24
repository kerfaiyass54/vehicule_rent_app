package com.projecttuto.vehicule_rental.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Entity
@Data
@Getter
@Builder
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

    @Column(name="supp_name", nullable=false, unique=true)
    private String suppName;

    @Column(name="nationality", nullable=false)
    private String nationality;

    @Column(name="email_supp", nullable = false, unique=true)
    private String email;

    @Column(name="pass_supp", nullable = false)
    private String pass;

    @Column(name="experience")
    private int experience;

    @ManyToOne
    @JoinColumn(name = "id_admin_supp", referencedColumnName = "idadmin")
    private Admin admin;

    @Column(name="role_user")
    private String role;

    @OneToMany(mappedBy = "supplier", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Vehicule> vehicules;

    @OneToMany(mappedBy = "supplier", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Adress> adresses;

    @OneToMany(mappedBy = "supplier", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Subscription> subscriptions;

    @OneToMany(mappedBy = "supplier", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Demand> demands;

    @OneToMany(mappedBy = "supplier", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Category> categories;


}
