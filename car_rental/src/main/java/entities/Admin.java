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
@Table(name="admin")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idadmin")
    private long idAdmin;

    @Column(name="admin_name")
    private String adminName;

    @Column(name="email_admin")
    private String email;

    @Column(name="pass_admin")
    private String pass;


    private List<Client> clients;

    private List<Repair> repairs;

    private List<Supplier> suppliers;

}
