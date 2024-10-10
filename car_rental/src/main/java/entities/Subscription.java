package entities;


import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name="subscription")
public class Subscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idSubscrip;

    private String type;

    private Date dateStart;

    private Date dateEnd;

    private long idSupplier;

    private long idClient;
}
