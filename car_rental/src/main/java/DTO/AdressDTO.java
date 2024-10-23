package DTO;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AdressDTO {
    private long idAdress;
    private String road;
    private int number;
}
