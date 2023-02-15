package com.example.taco.data;


import org.springframework.data.repository.CrudRepository;

import com.example.taco.Ingredient;

public interface IngredientRepository
        extends CrudRepository<Ingredient, String> {

}