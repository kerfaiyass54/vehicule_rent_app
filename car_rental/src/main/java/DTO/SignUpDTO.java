package DTO;

import enums.RoleUser;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SignUpDTO {
    private String name;
    private String email;
    private String password;
    private RoleUser role;

}
