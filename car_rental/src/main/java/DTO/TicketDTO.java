package DTO;

import enums.StatusRepair;
import enums.TypeTicket;

import java.util.Date;

public class TicketDTO {
    private long idTicket;
    private TypeTicket type;
    private Date dateInsert;
    private StatusRepair status;
    private float tarif;
}
