package com.example.demo.repository;

import com.example.demo.model.Redemption;
import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RedemptionRepository extends JpaRepository<Redemption, Integer> {
    Redemption findByFamilyId(int familyId);
    Redemption findByTreatmentId(int treatmentId);
}
