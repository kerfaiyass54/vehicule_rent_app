package entities;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="repair")
public class Repair {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idRepair;

    private String nameRepair;

    private long idLocation;

    private String email;

    private String pass;

    private long idAdmin;

}
