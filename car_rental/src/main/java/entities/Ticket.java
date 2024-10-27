package entities;

import enums.StatusRepair;
import enums.TypeTicket;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name="ticket")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idticket")
    private long idTicket;

    @Column(name="type")
    @Enumerated(EnumType.STRING)
    private TypeTicket type;

    @Column(name="date_insert")
    private LocalDate dateInsert;

    @Column(name="status")
    @Enumerated(EnumType.STRING)
    private StatusRepair status;

    @Column(name="tarif")
    private float tarif;

    @ManyToOne
    @JoinColumn(name = "id_rep", referencedColumnName = "idrepair")
    private Repair repair;

    @ManyToOne
    @JoinColumn(name = "id_client", referencedColumnName = "idclient")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "id_vehicule_ticket", referencedColumnName = "idvehicule")
    private Vehicule vehicule;

    @OneToMany(mappedBy = "ticket")
    private List<Demand> demands;



}
