package DTO;

import enums.SubscriptionType;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SubscriptionDTO {
    private long idSubscrip;
    private SubscriptionType type;
    private LocalDate dateStart;
    private LocalDate dateEnd;
    private double price;
    private int reduce;
}
