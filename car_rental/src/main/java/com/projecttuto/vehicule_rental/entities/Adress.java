package com.projecttuto.vehicule_rental.entities;

import com.projecttuto.vehicule_rental.enums.AdressStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

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

    @ManyToOne()
    @JoinColumn(name = "idsupp", referencedColumnName = "idsupp")
    private Supplier supplier;

    @ManyToOne
    @JoinColumn(name = "idloc", referencedColumnName = "idloc")
    private Location location;

    @Column(name="adress_status",nullable = false)
    private AdressStatus adressStatus;




}
