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


    private long idLocation;

    private long idAbon;

    private String email;

    private String pass;

    private long idAdmin;



}
