package entities;


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
@Table(name="location")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idloc")
    private long idLoc;

    @Column(name="name")
    private String name;

    @Column(name="country")
    private String country;

    @OneToMany(mappedBy = "location")
    private List<Adress> adresses;

    @OneToMany(mappedBy = "location")
    private List<Client> clients;

    @OneToMany(mappedBy = "location")
    private List<Repair> repairs;


}
