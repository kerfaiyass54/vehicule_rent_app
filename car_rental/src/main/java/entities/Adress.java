package entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="adress")
public class Adress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idAdress;

    private String road;

    private int number;

    private int idSupp;

    private int idLoc;


}
