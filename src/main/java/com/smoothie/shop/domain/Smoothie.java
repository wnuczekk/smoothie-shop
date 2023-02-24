package com.smoothie.shop.domain;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "smoothie")
public class Smoothie {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Ingredient> ingredients;
    @OneToOne(cascade = CascadeType.ALL)
    private NutritionValues nutritionValues;

    public Smoothie() {
    }

    public Smoothie(String name) {
        this.name = name;
    }

    public Smoothie(String name, List<Ingredient> ingredients, NutritionValues nutritionValues) {
        this.name = name;
        this.ingredients = ingredients;
        this.nutritionValues = nutritionValues;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public NutritionValues getNutritionValues() {
        return nutritionValues;
    }

    public void setNutritionValues(NutritionValues nutritionValues) {
        this.nutritionValues = nutritionValues;
    }
}
