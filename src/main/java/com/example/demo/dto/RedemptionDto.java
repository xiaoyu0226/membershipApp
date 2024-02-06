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
public class RedemptionDto {

    private int id;
    private LocalDate redemptionDate;
    private int tokenConsumed;
    private int family_id;
    private int treatment_id;
}
