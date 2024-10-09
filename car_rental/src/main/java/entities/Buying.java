package entities;


import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name="buyings")
public class Buying {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idBuy;

    private String type;

    private Date dateAsk;

    private String statusConfirm;

    private int idVehicule;

    private int idClient;


}
