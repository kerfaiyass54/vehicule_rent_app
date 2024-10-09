package entities;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="location")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idLoc;

    private String name;

    private String country;
}
