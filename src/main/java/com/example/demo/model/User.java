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
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private AppUserRole appUserRole;

//    @OneToOne(cascade = CascadeType.DETACH)
//    @JoinColumn(name = "client_id")
//    private Client client;
//
//    @OneToOne(cascade = CascadeType.DETACH)
//    @JoinColumn(name = "partner_id")
//    private Partner partner;
    private String password;
}