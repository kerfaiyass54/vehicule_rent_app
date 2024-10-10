package entities;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name="client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idclient")
    private long idClient;

    @Column(name="name_client",nullable = false)
    private String nameClient;

    @Column(name="cin",nullable = false)
    private String cin;

    @Column(name="budget",nullable = false)
    private double budget;

    @ManyToOne
    @JoinColumn(name = "id_location", referencedColumnName = "idloc")
    private Location location;

    @OneToMany
    private List<Subscription> subscriptions;

    @Column(name="email_client",nullable = false)
    private String email;

    @Column(name="pass_client",nullable = false)
    private String pass;

    @ManyToOne
    @JoinColumn(name = "id_admin_client", referencedColumnName = "idadmin")
    private Admin admin;



}
