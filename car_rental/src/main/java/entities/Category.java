package entities;


import enums.CategoryName;
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
@Table(name="category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idcategory")
    private long idCategory;

    @Enumerated(EnumType.STRING)
    @Column(name="name_category",nullable = false)
    private String nameCategory;

    @Enumerated(EnumType.STRING)
    @Column(name="type_category",nullable = false)
    private String typeCategory;

    @OneToMany(mappedBy = "category")
    private List<Vehicule> vehicules;





}
