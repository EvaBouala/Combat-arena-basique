package com.example.demo.repository;

import com.example.demo.personnages.Leo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeoRepository extends JpaRepository<Leo, Long> {
}