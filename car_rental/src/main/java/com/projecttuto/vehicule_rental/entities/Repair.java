package com.projecttuto.vehicule_rental.entities;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name="repair")
public class Repair {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idrepair")
    private long idRepair;

    @Column(name="name_repair")
    private String nameRepair;

    @ManyToOne
    @JoinColumn(name= "id_location",referencedColumnName = "idloc")
    private Location location;

    @Column(name="email_repair")
    private String email;

    @Column(name="pass_repair")
    private String pass;

    @Column(name="role_user", nullable = false)
    private String role;

    @ManyToOne
    @JoinColumn(name = "id_admin_rep", referencedColumnName = "idadmin")
    private Admin admin;

    @OneToMany(mappedBy = "repair")
    private List<Ticket> tickets;

    @OneToMany(mappedBy = "repair")
    private List<RepairInfo> repairInfos;

}
