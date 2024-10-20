package repositories;

import entities.Category;
import enums.CategoryName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    public Category findCategoriesByNameCategory(CategoryName nameCategory);

}
