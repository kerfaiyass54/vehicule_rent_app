package com.projecttuto.vehicule_rental.DTO;

import com.projecttuto.vehicule_rental.enums.CategoryName;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CategoryDTO {
    private long idCategory;
    private CategoryName nameCategory;
    private String typeCategory;
}
