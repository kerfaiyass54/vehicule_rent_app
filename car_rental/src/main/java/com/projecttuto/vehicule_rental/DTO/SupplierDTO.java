package com.projecttuto.vehicule_rental.DTO;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SupplierDTO {
    private long idSupp;
    private String suppName;
    private String nationality;
    private String email;
    private String role;


}
