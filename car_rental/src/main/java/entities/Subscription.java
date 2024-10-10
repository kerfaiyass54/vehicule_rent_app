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
@Table(name="subscription")
public class Subscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idsubscrip")
    private long idSubscrip;

    @Column(name="type")
    private String type;

    @Column(name="date_start")
    private Date dateStart;

    @Column(name="date_end")
    private Date dateEnd;

    @ManyToOne
    private Supplier supplier;

    @ManyToOne
    private Client client;
}
