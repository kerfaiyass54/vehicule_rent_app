package com.projecttuto.vehicule_rental.entities;


import com.projecttuto.vehicule_rental.enums.CategoryName;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@Data
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name="category.sql")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idcategory")
    private long idCategory;

    @Enumerated(EnumType.STRING)
    @Column(name="name_category",nullable = false)
    private CategoryName nameCategory;

    @Column(name="type_category",nullable = false,unique = true)
    private String typeCategory;

    @OneToMany(mappedBy = "category" , fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Vehicule> vehicules;

    @ManyToOne
    @JoinColumn(name = "id_supp_cat", referencedColumnName = "idsupp")
    private Supplier supplier;






}
