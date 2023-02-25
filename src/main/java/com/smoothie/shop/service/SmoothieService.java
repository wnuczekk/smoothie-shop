package com.smoothie.shop.service;

import com.smoothie.shop.domain.Ingredient;
import com.smoothie.shop.domain.Smoothie;
import com.smoothie.shop.repository.SmoothieRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SmoothieService {

    SmoothieRepository smoothieRepository;

    @Autowired
    public SmoothieService(SmoothieRepository smoothieRepository) {
        this.smoothieRepository = smoothieRepository;
    }

    @Transactional
    public Smoothie create(Smoothie smoothie) {
        return smoothieRepository.save(filterOutEmptyIngredients(smoothie));
    }

    @Transactional
    public Smoothie update(Smoothie smoothie) {
        return smoothieRepository.save(filterOutEmptyIngredients(smoothie));
    }

    public void delete(Long id) {
        smoothieRepository.deleteById(id);
    }

    public List<Smoothie> getAll() {
        return smoothieRepository.findAll();
    }

    public Optional<Smoothie> get(Long id) {
        return smoothieRepository.findById(id);
    }

    private Smoothie filterOutEmptyIngredients(Smoothie smoothie) {
        List<Ingredient> ingredients = smoothie.getIngredients().stream()
                .filter(ingredient -> !ingredient.getName().isBlank() || ingredient.getWeight() != null)
                .toList();

        smoothie.setIngredients(ingredients);
        return smoothie;
    }
}
