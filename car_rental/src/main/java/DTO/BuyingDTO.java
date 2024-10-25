package DTO;

import enums.BuyStatus;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BuyingDTO {
    private long idBuying;
    private LocalDate dateBuy;
    private BuyStatus buyStatus;

}
