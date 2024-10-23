package DTO;

import enums.ConfirmStatus;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DemandDTO {
    private long idDemand;
    private String type;
    private LocalDate dateAsk;
    private ConfirmStatus statusConfirm;

}
