package com.example.demo.repository;

import com.example.demo.model.AppUserRole;
import com.example.demo.model.Client;
import com.example.demo.model.Partner;
import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Integer> {
    List<Client> findByFamilyId(int familyId);
    Client findByUserId(int userId);

    Optional<Client> findByEmail(String email);

    Optional<Client> findByPhone(String phone);
}
