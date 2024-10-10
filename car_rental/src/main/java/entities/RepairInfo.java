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

    private long idVehiculeRepair;

    private long idRepairRepair;


}
