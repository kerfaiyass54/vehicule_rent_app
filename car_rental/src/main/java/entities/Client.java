package entities;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idClient;

    private String nameClient;

    private String cin;

    private double budget;

    private int idLocation;
//le client peut posseder plusieurs abonnements
    private int idAbon;


}
