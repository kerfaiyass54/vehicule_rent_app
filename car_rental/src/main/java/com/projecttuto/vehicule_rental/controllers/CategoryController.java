package com.projecttuto.vehicule_rental.controllers;


import com.projecttuto.vehicule_rental.entities.Category;
import com.projecttuto.vehicule_rental.entities.Vehicule;
import com.projecttuto.vehicule_rental.enums.CategoryName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.projecttuto.vehicule_rental.services.CategoryService;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/vehicules/{name}")
    List<Vehicule> getVehiculesByName(@PathVariable CategoryName name){
        return categoryService.getVehiculesByName(name);
    }

    @GetMapping("/types/{name}")
    List<String> getCategoryTypes(@PathVariable CategoryName name){
        return categoryService.getCategoryTypes(name);
    }

    @PostMapping("/add")
    void addCategory(@RequestBody Category category,@RequestParam String nameSupplier){
        categoryService.addCategory(category, nameSupplier);
    }

    @DeleteMapping("/delete")
    void deleteCategory(@RequestBody Category category){
        categoryService.deleteCategory(category);
    }
}
