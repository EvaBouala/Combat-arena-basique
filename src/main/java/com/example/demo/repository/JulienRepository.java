package com.example.demo.repository;

import com.example.demo.personnages.Julien;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JulienRepository extends JpaRepository<Julien, Long> {
}