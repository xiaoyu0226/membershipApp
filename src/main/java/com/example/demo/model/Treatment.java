package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Treatment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String providerName;
    private String treatmentName;
    private int timeLength;
    private int tokenNeeded;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "partner_id")
    private Partner partner;

    private Boolean isActive;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "family_id")
    private List<Family> family = new ArrayList<Family>();
}