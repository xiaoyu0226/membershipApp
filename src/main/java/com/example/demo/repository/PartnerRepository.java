package com.example.demo.repository;

import com.example.demo.model.Partner;
import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PartnerRepository extends JpaRepository<Partner, Integer> {

    Partner findByUserId(int userId);

    Optional<Partner> findByEmail(String partnerEmail);

    Optional<Partner> findByClinicname(String partnerName);
}
