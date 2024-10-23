package DTO;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BuyingDTO {
    private long idBuying;
    private Date dateBuy;

}
