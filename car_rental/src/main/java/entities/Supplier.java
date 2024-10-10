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

    @ManyToOne
    private Admin admin;

    @OneToMany
    private List<Vehicule> vehicules;

    @OneToMany
    private List<Adress> adresses;

    @OneToMany
    private List<Subscription> subscriptions;

    @OneToMany
    private List<Demand> demands;


}
