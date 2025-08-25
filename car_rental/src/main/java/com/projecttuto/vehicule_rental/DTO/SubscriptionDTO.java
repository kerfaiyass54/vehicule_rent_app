package com.projecttuto.vehicule_rental.DTO;

import com.projecttuto.vehicule_rental.enums.SubscriptionType;
import lombok.*;

import java.time.Instant;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SubscriptionDTO {
    private long idSubscrip;
    private SubscriptionType type;
    private Instant dateStart;
    private double price;
    private int reduce;
}
