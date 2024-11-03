package com.projecttuto.vehicule_rental.DTO;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LocationDTO {
    private long idLoc;
    private String name;
    private String country;

}
