package DTO;

import enums.SubscriptionType;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SubscriptionDTO {
    private long idSubscrip;
    private SubscriptionType type;
    private Date dateStart;
    private Date dateEnd;
}
