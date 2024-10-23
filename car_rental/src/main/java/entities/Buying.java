package entities;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name="buyings")
public class Buying {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idbuying")
    private long idBuying;

    @Column(name="date_buy")
    private LocalDate dateBuy;

    @Column(name="period_buy")
    private int periodBuy;

    @ManyToOne
    @JoinColumn(name = "id_vehicule", referencedColumnName = "idvehicule")
    private Vehicule vehicule;

    @ManyToOne
    @JoinColumn(name = "id_client", referencedColumnName = "idclient")
    private Client client;




}
