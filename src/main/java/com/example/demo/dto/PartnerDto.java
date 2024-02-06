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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PartnerDto {

    private int id;
    private String clinicname;
    private String email;
    private String phone;
    private String address;
    private List<TreatmentDto> treatmentDtos = new ArrayList<TreatmentDto>();
    private Boolean isActive;
    private User user;
}
