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
@Table(name="location")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idloc")
    private long idLoc;

    @Column(name="name",nullable=false)
    private String name;

    @Column(name="country",nullable=false)
    private String country;

    @Column(name="position",nullable=false)
    private String position;

    @OneToMany(mappedBy = "location", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Adress> adresses;

    @OneToMany(mappedBy = "location", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Client> clients;

    @OneToMany(mappedBy = "location", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Repair> repairs;

    @ManyToOne
    @JoinColumn(name="id_admin_loc",referencedColumnName = "idadmin")
    private Admin admin;


}
