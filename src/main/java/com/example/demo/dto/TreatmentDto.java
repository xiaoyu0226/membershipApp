package com.example.demo.dto;

import com.example.demo.model.*;
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
public class TreatmentDto {
    private int id;
    private String providerName;
    private String treatmentName;
    private int timeLength;
    private int tokenNeeded;
    private int partner_id;

    private Boolean isActive;

    private List<Family> family = new ArrayList<Family>();
}
