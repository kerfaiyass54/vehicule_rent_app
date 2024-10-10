package entities;


import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name="repair_info")
public class RepairInfo {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idInfo;

    private Date dateStart;

    private String repairStatus;

    private long idVehiculeRepair;

    private long idRepairRepair;


}
