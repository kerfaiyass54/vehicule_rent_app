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

    @Column(name="name_client")
    private String nameClient;

    @Column(name="cin")
    private String cin;

    @Column(name="budget")
    private double budget;

    @ManyToOne
    @JoinColumn(name = "id_location", referencedColumnName = "idloc")
    private Location location;

    @OneToMany(mappedBy = "client")
    private List<Subscription> subscriptions;

    @OneToMany(mappedBy = "client")
    private List<Buying> buyings;

    @OneToMany(mappedBy = "client")
    private List<Ticket> tickets;

    @Column(name="email_client",nullable = false)
    private String email;

    @Column(name="pass_client",nullable = false)
    private String pass;

    @Column(name="role_user", nullable = false)
    private String role;

    @ManyToOne
    @JoinColumn(name = "id_admin_client", referencedColumnName = "idadmin")
    private Admin admin;



}
