package com.projecttuto.vehicule_rental.DTO;

import com.projecttuto.vehicule_rental.enums.RepairStatus;
import lombok.*;

import java.time.Instant;
import java.time.Instant;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RepairInfoDTO {
    private long idInfo;
    private RepairStatus repairStatus;
    private Instant dateStart;
}
