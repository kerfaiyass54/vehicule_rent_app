package entities;


import enums.ConfirmStatus;
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
    @Enumerated(EnumType.STRING)
    private ConfirmStatus statusConfirm;

    @ManyToOne
    @JoinColumn(name = "id_ticket", referencedColumnName = "idticket")
    private Ticket ticket;

    @ManyToOne
    @JoinColumn(name = "id_supp", referencedColumnName = "idsupp")
    private Supplier supplier;
}
