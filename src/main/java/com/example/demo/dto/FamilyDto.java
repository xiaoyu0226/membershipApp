package com.example.demo.dto;

import com.example.demo.model.Client;
import com.example.demo.model.Family;
import com.example.demo.model.Treatment;
import com.example.demo.model.User;
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
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FamilyDto {

    private int id;
    private String name;
    private int tokens;
    private String email;
    private String membershipLevel;
    private LocalDate joinedAt;
    private LocalDate expiredAt;
    private Boolean isActive;
    private List<ClientDto> clientsDto = new ArrayList<>();
    private List<Treatment> treatments = new ArrayList<Treatment>();
}
