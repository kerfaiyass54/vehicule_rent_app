package entities;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="repair")
public class Repair {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRepair;

    private String nameRepair;

    private int idLocation;

}
