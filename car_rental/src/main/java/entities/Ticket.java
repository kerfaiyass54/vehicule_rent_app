package entities;

import enums.TypeTicket;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

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
    private Date dateInsert;

    @Column(name="status")
    private String status;

    @ManyToOne
    @JoinColumn(name = "id_rep", referencedColumnName = "idrepair")
    private Repair repair;

    @ManyToOne
    @JoinColumn(name = "id_client", referencedColumnName = "idclient")
    private Client client;
}
