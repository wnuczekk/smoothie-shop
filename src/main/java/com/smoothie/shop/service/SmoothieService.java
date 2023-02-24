package com.smoothie.shop.service;

import com.smoothie.shop.domain.Smoothie;
import com.smoothie.shop.repository.SmoothieRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SmoothieService {

    SmoothieRepository smoothieRepository;

    @Autowired
    public SmoothieService(SmoothieRepository smoothieRepository) {
        this.smoothieRepository = smoothieRepository;
    }

    @Transactional
    public Smoothie create(Smoothie smoothie) {
        return smoothieRepository.save(smoothie);
    }

    public Smoothie update(Long id, String name) {
        Smoothie smoothie = smoothieRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        smoothie.setName(name);

        return smoothieRepository.save(smoothie);
    }

    public List<Smoothie> getAll() {
        return smoothieRepository.findAll();
    }
}
