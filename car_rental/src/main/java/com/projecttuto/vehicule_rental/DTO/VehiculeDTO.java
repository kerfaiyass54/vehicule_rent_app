package com.projecttuto.vehicule_rental.DTO;

import com.projecttuto.vehicule_rental.enums.Transmission;
import com.projecttuto.vehicule_rental.enums.VehiculeStatus;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class VehiculeDTO {
    private long idVehicule;
    private String nameVehicule;
    private String color;
    private String brand;
    private double price;
    private int highSpeed;
    private Transmission transmission;
    private VehiculeStatus vehiculeStatus;

}
