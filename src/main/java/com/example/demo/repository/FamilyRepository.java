package com.example.demo.repository;

import com.example.demo.model.Client;
import com.example.demo.model.Family;
import com.example.demo.model.Treatment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FamilyRepository extends JpaRepository<Family, Integer> {
    Optional<List<Family>> findFamiliesByTreatments(int treatmentId);

    Optional<List<Family>> findByName(String name);

    Optional<Family> findByEmail(String email);
}
