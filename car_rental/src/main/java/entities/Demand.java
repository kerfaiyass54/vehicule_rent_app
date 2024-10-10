package entities;


import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Data
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name="demand")
public class Demand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="iddemand")
    private long idDemand;

    @Column(name="type")
    private String type;

    @Column(name="date_ask")
    private Date dateAsk;

    @Column(name="status_confirm")
    private String statusConfirm;

    private long idTicket;

    private long idSupp;
}
