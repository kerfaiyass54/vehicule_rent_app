package entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

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

    private List<Client> clients;

    private List<Repair> repairs;

    private List<Supplier> suppliers;

}
