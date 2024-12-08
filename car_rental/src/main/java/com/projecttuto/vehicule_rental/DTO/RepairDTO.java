package com.projecttuto.vehicule_rental.DTO;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RepairDTO {
    private long idRepair;
    private String nameRepair;
    private String locationName;
    private String email;
    private String pass;
    private String role;

}
