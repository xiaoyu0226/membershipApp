package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Family {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int tokens;
    @Column(unique = true)
    private String email;
    private String membershipLevel;
    private LocalDate joinedAt = LocalDate.now();
    private LocalDate expiredAt = joinedAt.plusYears(1);
    private Boolean isActive;

    // include an email and make this unique ... link to Client
    @OneToMany(mappedBy = "family", fetch = FetchType.LAZY, orphanRemoval = false)
//    @JsonManagedReference
    private List<Client> clients = new ArrayList<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "treatment_id")
    private List<Treatment> treatments = new ArrayList<Treatment>();
}
