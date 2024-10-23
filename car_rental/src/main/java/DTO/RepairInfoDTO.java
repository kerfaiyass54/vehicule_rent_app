package DTO;

import enums.RepairStatus;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RepairInfoDTO {
    private long idInfo;
    private RepairStatus repairStatus;
    private LocalDate dateStart;
}
