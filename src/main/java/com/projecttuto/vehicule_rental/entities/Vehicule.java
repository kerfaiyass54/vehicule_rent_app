package com.projecttuto.vehicule_rental.entities;

import com.projecttuto.vehicule_rental.enums.Transmission;
import com.projecttuto.vehicule_rental.enums.VehiculeStatus;
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
@Table(name="vehicule")
public class Vehicule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idvehicule")
    private long idVehicule;

    @Column(name="name_vehicule", nullable=false, unique=true)
    private String nameVehicule;

    @Column(name="color", nullable=false)
    private String color;

    @Column(name="brand", nullable = false)
    private String brand;

    @Column(name="price", nullable = false)
    private double price;

    @Column(name="high_speed", nullable = false)
    private int highSpeed;

    @Column(name="transmission", nullable = false)
    @Enumerated(EnumType.STRING)
    private Transmission transmission;

    @Column(name="vehicule_status")
    @Enumerated(EnumType.STRING)
    private VehiculeStatus vehiculeStatus;

    @ManyToOne
    @JoinColumn(name = "id_supp", referencedColumnName = "idsupp")
    private Supplier supplier;

    @ManyToOne
    @JoinColumn(name = "id_category", referencedColumnName = "idcategory")
    private Category category;

    @OneToMany(mappedBy = "vehicule", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<RepairInfo> repairInfos;

    @OneToMany(mappedBy = "vehicule", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Buying> buyings;

    @OneToMany(mappedBy = "vehicule", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Ticket> tickets;





}
