package com.example.demo.service;

import com.example.demo.dto.FamilyDto;
import com.example.demo.dto.TreatmentDto;
import com.example.demo.dto.UserDto;

import java.util.List;

public interface TreatmentService {

    List<TreatmentDto> getAllTreatments();

    TreatmentDto getTreatmentById(int id);

    TreatmentDto createTreatment(TreatmentDto treatmentDto);

    TreatmentDto updateTreatmentId(TreatmentDto treatmentDto, int treatmentId);

    TreatmentDto deleteTreatmentId(int treatmentId);
}
