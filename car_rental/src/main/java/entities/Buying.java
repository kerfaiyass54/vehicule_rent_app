package entities;


import jakarta.persistence.*;
import lombok.*;

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
    private Date dateBuy;

    private long idVehicule;

    private long idClient;


}
