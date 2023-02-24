package com.smoothie.shop.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "nutrition_values")
public class NutritionValues {
    @Id
    @GeneratedValue
    private Long id;
    private Integer fat;
    private Integer carbohydrates;
    private Integer protein;
    private Integer minerals;
    private Integer vitamins;

    public NutritionValues() {
    }

    public NutritionValues(Integer fat, Integer carbohydrates, Integer protein, Integer minerals, Integer vitamins) {
        this.fat = fat;
        this.carbohydrates = carbohydrates;
        this.protein = protein;
        this.minerals = minerals;
        this.vitamins = vitamins;
    }

    public Integer getFat() {
        return fat;
    }

    public void setFat(Integer fat) {
        this.fat = fat;
    }

    public Integer getCarbohydrates() {
        return carbohydrates;
    }

    public void setCarbohydrates(Integer carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    public Integer getProtein() {
        return protein;
    }

    public void setProtein(Integer protein) {
        this.protein = protein;
    }

    public Integer getMinerals() {
        return minerals;
    }

    public void setMinerals(Integer minerals) {
        this.minerals = minerals;
    }

    public Integer getVitamins() {
        return vitamins;
    }

    public void setVitamins(Integer vitamins) {
        this.vitamins = vitamins;
    }
}
