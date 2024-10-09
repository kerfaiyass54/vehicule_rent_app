package entities;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCategory;

    private String nameCategory;

    private String typeCategory;




}
