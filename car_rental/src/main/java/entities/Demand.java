package entities;


import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name="demand")
public class Demand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDemand;

    private String type;

    private Date dateAsk;

    private String statusConfirm;

    private int idTicket;

    private int idSupp;
}
