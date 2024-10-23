package entities;


import enums.SubscriptionType;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Data
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name="subscription")
public class Subscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idsubscrip")
    private long idSubscrip;

    @Column(name="type")
    @Enumerated(EnumType.STRING)
    private SubscriptionType type;

    @Column(name="date_start")
    private LocalDate dateStart;

    @Column(name="date_end")
    private LocalDate dateEnd;

    @ManyToOne
    @JoinColumn(name = "id_supplier", referencedColumnName = "idsupp")
    private Supplier supplier;

    @ManyToOne
    @JoinColumn(name = "id_client", referencedColumnName = "idclient")
    private Client client;
}
