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
public class Partner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true)
    private String clinicname;
    @Column(unique = true)
    private String email;
    private String phone;
    private String address;

    @OneToMany(mappedBy = "partner", cascade = CascadeType.DETACH, orphanRemoval = false)
    private List<Treatment> treatments = new ArrayList<Treatment>();

    private Boolean isActive;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "user_id")
    private User user;
}