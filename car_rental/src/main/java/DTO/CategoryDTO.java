package DTO;

import enums.CategoryName;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CategoryDTO {
    private int idCategory;
    private CategoryName nameCategory;
    private String typeCategory;
}
