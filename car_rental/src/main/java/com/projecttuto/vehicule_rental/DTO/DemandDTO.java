package com.projecttuto.vehicule_rental.DTO;

import com.projecttuto.vehicule_rental.enums.ConfirmStatus;
import lombok.*;

import java.time.Instant;
import java.time.Instant;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DemandDTO {
    private long idDemand;
    private String type;
    private Instant dateAsk;
    private ConfirmStatus statusConfirm;

}
