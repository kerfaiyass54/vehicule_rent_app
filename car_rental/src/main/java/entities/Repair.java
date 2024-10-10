package entities;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name="repair")
public class Repair {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idrepair")
    private long idRepair;

    @Column(name="name_repair")
    private String nameRepair;

    private long idLocation;

    @Column(name="email_repair")
    private String email;

    @Column(name="pass_repair")
    private String pass;

    @ManyToOne
    @JoinColumn(name = "id_admin_rep", referencedColumnName = "idadmin")
    private Admin admin;

    @OneToMany
    private List<Ticket> tickets;

    @OneToMany
    private List<RepairInfo> repairInfos;

}
