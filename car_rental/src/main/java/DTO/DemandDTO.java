package DTO;

import enums.ConfirmStatus;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DemandDTO {
    private long idDemand;
    private String type;
    private Date dateAsk;
    private ConfirmStatus statusConfirm;

}
