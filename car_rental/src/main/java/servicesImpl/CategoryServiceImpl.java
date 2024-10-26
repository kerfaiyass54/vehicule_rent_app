package servicesImpl;


import entities.Category;
import entities.Supplier;
import entities.Vehicule;
import enums.CategoryName;
import enums.CategoryType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.CategoryRepository;
import repositories.SupplierRepository;
import repositories.VehiculeRepository;
import services.CategoryService;

import java.util.Arrays;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private VehiculeRepository vehiculeRepository;

    @Autowired
    private SupplierRepository supplierRepository;



    @Override
    public List<Vehicule> getVehiculesByName(CategoryName name){
        return categoryRepository.findCategoriesByNameCategory(name).getVehicules();
    }

    @Override
    public void addCategory(Category category, String nameSupplier){
        Supplier supplier = supplierRepository.findSupplierBySuppName(nameSupplier);
        category.setSupplier(supplier);
        categoryRepository.save(category);
    }

    @Override
    public void deleteCategory(Category category){
        Category c = categoryRepository.getById(category.getIdCategory());
        if(c.getVehicules().isEmpty()){

            categoryRepository.delete(category);

        }
    }

    @Override
    public List<String> getCategoryTypes(CategoryName name){
        switch (name){
            case PASSENGER_VEHICLES:
                return Arrays.asList(CategoryType.PASSENGER_VEHICLES);

            case COMMERCIAL_VEHICLES:
                return Arrays.asList(CategoryType.COMMERCIAL_VEHICLES);

            case MOTORCYCLES:
                return Arrays.asList(CategoryType.MOTORCYCLES);

            case ELECTRIC_VEHICLES:
                return Arrays.asList(CategoryType.ELECTRIC_VEHICLES);

            case OFF_ROAD_VEHICLES:
                return Arrays.asList(CategoryType.OFF_ROAD_VEHICLES);

            case HEAVY_DUTY_VEHICLES:
                return Arrays.asList(CategoryType.HEAVY_DUTY_VEHICLES);

            case EMERGENCY_VEHICLES:
                return Arrays.asList(CategoryType.EMERGENCY_VEHICLES);

            case AGRICULTURAL_VEHICLES:
                return Arrays.asList(CategoryType.AGRICULTURAL_VEHICLES);

            case MARINE_VEHICLES:
                return Arrays.asList(CategoryType.MARINE_VEHICLES);

            case AERIAL_VEHICLES:
                return Arrays.asList(CategoryType.AERIAL_VEHICLES);

            default:
                return null;

        }
    }




}
