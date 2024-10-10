package entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Entity
@Data
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name="supplier")
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idsupp")
    private long idSupp;

    @Column(name="supp_name")
    private String suppName;

    @Column(name="nationality")
    private String nationality;

    @Column(name="email_supp")
    private String email;

    @Column(name="pass_supp")
    private String pass;

    private long idAdmin;

    private List<Vehicule> vehicules;

    private List<Adress> adresses;

    private List<Subscription> subscriptions;

    private List<Demand> demands;


}
