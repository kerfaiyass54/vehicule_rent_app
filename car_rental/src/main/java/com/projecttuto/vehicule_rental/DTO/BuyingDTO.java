package com.projecttuto.vehicule_rental.DTO;

import com.projecttuto.vehicule_rental.enums.BuyStatus;
import lombok.*;

import java.time.LocalDate;

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
