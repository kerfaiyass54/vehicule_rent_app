package DTO;

import enums.StatusRepair;
import enums.TypeTicket;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TicketDTO {
    private long idTicket;
    private TypeTicket type;
    private Date dateInsert;
    private StatusRepair status;
    private float tarif;
}
