package com.smoothie.shop.api;

import com.smoothie.shop.domain.Smoothie;
import com.smoothie.shop.service.SmoothieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/smoothies")
public class SmoothieController {

    private final SmoothieService smoothieService;

    @Autowired
    public SmoothieController(SmoothieService smoothieService) {
        this.smoothieService = smoothieService;
    }

    @PostMapping
    public ResponseEntity<Smoothie> createSmoothie(@RequestBody Smoothie smoothie) throws URISyntaxException {
        Smoothie savedSmoothie = smoothieService.create(smoothie);
        return ResponseEntity.created(new URI("/clients/" + savedSmoothie.getId())).body(savedSmoothie);
    }

    @GetMapping
    public List<Smoothie> getAllSmoothies() {
        return smoothieService.getAll();
    }
}
