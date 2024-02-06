package com.example.demo.repository;

import com.example.demo.model.AppUserRole;
import com.example.demo.model.Client;
import com.example.demo.model.Partner;
import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<List<User>> findByAppUserRole(AppUserRole appUserRole);


}


