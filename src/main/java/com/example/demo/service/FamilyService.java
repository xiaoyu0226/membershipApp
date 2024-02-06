package com.example.demo.service;

import com.example.demo.dto.FamilyDto;

import java.util.List;

public interface FamilyService {
    List<FamilyDto> getAllFamilies();

    FamilyDto getFamilyById(int id);

//    List<FamilyDto> getFamilyByName(String name);
    FamilyDto getFamilyByEmail(String email);

    FamilyDto createFamily(FamilyDto familyDto);

    FamilyDto updateFamilyId(FamilyDto familyDto, int familyId);

    FamilyDto deleteFamilyId(int familyId);

    FamilyDto deleteFamilyEmail(String familyEmail);

    FamilyDto updateFamilyEmail(FamilyDto familyDto, String familyEmail);
}
