package entities;

import enums.AdressStatus;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

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

    @Column(name="road",nullable = false)
    private String road;

    @Column(name="number",nullable = false)
    private int number;

    @ManyToOne
    @JoinColumn(name = "idsupp", referencedColumnName = "idsupp")
    private Supplier supplier;

    @ManyToOne
    @JoinColumn(name = "idloc", referencedColumnName = "idloc")
    private Location location;

    @Column(name="adress_status",nullable = false)
    private AdressStatus adressStatus;




}
