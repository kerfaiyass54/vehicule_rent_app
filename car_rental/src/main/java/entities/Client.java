package entities;


import jakarta.persistence.*;
import lombok.*;

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

    private long idLocation;

    private long idAbon;

    @Column(name="email_client")
    private String email;

    @Column(name="pass_client")
    private String pass;

    private long idAdmin;



}
