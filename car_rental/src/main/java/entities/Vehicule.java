package entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="vehicule")
public class Vehicule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idVehicule;

    private String nameVehicule;

    private String color;

    private String brand;

    private double price;

    private int highSpeed;

    private String transmission;

    private long idSupp;

    private long idCategory;

}
