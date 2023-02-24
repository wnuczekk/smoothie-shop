package com.smoothie.shop.repository;

import com.smoothie.shop.domain.Smoothie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SmoothieRepository extends JpaRepository<Smoothie, Long> {
}
