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

    @Column(name="admin_name", nullable = false)
    private String adminName;

    @Column(name="email_admin", nullable = false)
    private String email;

    @Column(name="pass_admin", nullable = false)
    private String pass;

    @OneToMany(mappedBy = "admin")
    private List<Client> clients;

    @OneToMany(mappedBy = "admin")
    private List<Repair> repairs;

    @OneToMany(mappedBy = "admin")
    private List<Supplier> suppliers;

}
