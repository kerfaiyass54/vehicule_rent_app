package entities;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idClient;

    private String nameClient;

    private String cin;

    private double budget;

    private int idLocation;

    private int idAbon;


}
