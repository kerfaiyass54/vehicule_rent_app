package entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name="adress")
public class Adress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idadress")
    private long idAdress;

    @Column(name="road")
    private String road;


    @Column(name="number")
    private int number;

    private long idSupp;

    private long idLoc;


}
