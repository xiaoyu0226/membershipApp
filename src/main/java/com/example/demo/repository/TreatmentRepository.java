package com.example.demo.repository;

import com.example.demo.model.Family;
import com.example.demo.model.Treatment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TreatmentRepository extends JpaRepository<Treatment, Integer> {
    Optional<List<Treatment>> findByPartnerId(int partnerId);
    Optional<List<Treatment>> findTreatmentsByFamilyId(int familyId);

}
