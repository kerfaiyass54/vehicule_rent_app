package services;

import entities.Category;
import entities.Vehicule;
import enums.CategoryName;
import enums.CategoryType;

import java.util.List;

public interface CategoryService {


    List<Vehicule> getVehiculesByName(CategoryName name);
    List<String> getCategoryTypes(CategoryName name);
    void addCategory(Category category, String nameSupplier);
    void deleteCategory(Category category);



}
