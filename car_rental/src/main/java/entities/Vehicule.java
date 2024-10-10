package entities;

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
    private String transmission;

    @ManyToOne
    private Supplier supplier;

    @ManyToOne
    private Category category;

    @OneToMany
    private List<RepairInfo> repairInfos;

    @OneToMany
    private List<Buying> buyings;





}
