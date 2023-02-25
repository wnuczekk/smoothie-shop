package com.smoothie.shop.api;

import com.smoothie.shop.domain.Smoothie;
import com.smoothie.shop.service.SmoothieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/smoothies")
public class SmoothieController {

    private final SmoothieService smoothieService;

    @Autowired
    public SmoothieController(SmoothieService smoothieService) {
        this.smoothieService = smoothieService;
    }

    @PostMapping
    public ResponseEntity<Smoothie> create(@RequestBody Smoothie smoothie) throws URISyntaxException {
        return ResponseEntity.ok(smoothieService.create(smoothie));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Smoothie> update(@RequestBody Smoothie smoothie) throws URISyntaxException {
        return ResponseEntity.ok(smoothieService.update(smoothie));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) throws URISyntaxException {
        smoothieService.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public List<Smoothie> getAllSmoothies() {
        return smoothieService.getAll();
    }

    @GetMapping("/{id}")
    ResponseEntity<?> getSmoothie(@PathVariable Long id) {
        Optional<Smoothie> smoothie = smoothieService.get(id);
        return smoothie.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
