package entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;


@Entity
@Data
@Table(name="supplier")
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idSupp;

    private String suppName;

    private String nationality;

    private String email;

    private String pass;

    private long idAdmin;

    private List<Vehicule> vehicules;

    private List<Adress> adresses;

    private List<Subscription> subscriptions;

    private List<Demand> demands;


}
