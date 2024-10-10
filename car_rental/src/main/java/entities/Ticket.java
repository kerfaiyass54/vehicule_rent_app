package entities;

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
    private String type;

    @Column(name="date_insert")
    private Date dateInsert;

    @Column(name="status")
    private String status;

    @OneToMany
    private Repair repair;

    @ManyToOne
    private Client client;
}
