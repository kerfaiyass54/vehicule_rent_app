package entities;


import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Data
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name="repair_info")
public class RepairInfo {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idinfo")
    private long idInfo;

    @Column(name="date_start")
    private Date dateStart;

    @Column(name="repair_status")
    private String repairStatus;

    @ManyToOne
    @JoinColumn(name = "id_vehicule_repair", referencedColumnName = "idvehicule")
    private Vehicule vehicule;

    @ManyToOne
    @JoinColumn(name = "id_repair_repair", referencedColumnName = "idrepair")
    private Repair repair;


}
