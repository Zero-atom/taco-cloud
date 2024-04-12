package com.example.tacocloud.repository;
import com.example.tacocloud.domain.Ingredient;

public interface IngredientRepository {

    Iterable<Ingredient> findAll();

    Ingredient findById(String id);

    Ingredient save(Ingredient ingredient);

    Ingredient findOne(String id);//убрать
}
