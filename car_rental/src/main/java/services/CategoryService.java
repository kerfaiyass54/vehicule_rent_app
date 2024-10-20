package services;

import entities.Category;
import entities.Vehicule;
import enums.CategoryName;
import enums.CategoryType;

import java.util.List;

public interface CategoryService {

    List<Vehicule> getVehiculesByType(CategoryType type);
    List<Vehicule> getVehiculesByName(CategoryName name);
    List<String> getCategoryTypes(CategoryName name);



}
