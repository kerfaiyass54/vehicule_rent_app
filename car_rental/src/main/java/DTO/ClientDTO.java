package DTO;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ClientDTO {
    private long idClient;
    private String nameClient;
    private String cin;
    private double budget;
    private String locationName;
    private String email;


}
