package entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="admin")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idAdmin;

    private String adminName;

    private String email;

    private String pass;

}
