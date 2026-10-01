package com.example.demo.repository;

import com.example.demo.personnages.Challenger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChallengerRepository extends JpaRepository<Challenger, Long> {
}