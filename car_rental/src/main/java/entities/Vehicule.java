package entities;

import enums.Transmission;
import enums.VehiculeStatus;
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

    @Column(name="name_vehicule")
    private String nameVehicule;

    @Column(name="color")
    private String color;

    @Column(name="brand")
    private String brand;

    @Column(name="price")
    private double price;

    @Column(name="high_speed")
    private int highSpeed;

    @Column(name="transmission")
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

    @OneToMany(mappedBy = "vehicule")
    private List<RepairInfo> repairInfos;

    @OneToMany(mappedBy = "vehicule")
    private List<Buying> buyings;

    @OneToMany(mappedBy = "vehicule")
    private List<Ticket> tickets;





}
